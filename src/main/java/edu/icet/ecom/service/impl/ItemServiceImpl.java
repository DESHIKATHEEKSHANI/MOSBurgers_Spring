package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.ItemDTO;
import edu.icet.ecom.entity.Item;
import edu.icet.ecom.repository.ItemRepository;
import edu.icet.ecom.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Override
    public ItemDTO addItem(ItemDTO itemDTO) {
        Item item = modelMapper.map(itemDTO, Item.class);
        Item savedItem = itemRepository.save(item);
        return modelMapper.map(savedItem, ItemDTO.class);
    }

    @Override
    public List<ItemDTO> getAll() {
        return itemRepository.findAll().stream()
                .map(item -> modelMapper.map(item, ItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO searchById(Long id) {
        return itemRepository.findById(id)
                .map(item -> modelMapper.map(item, ItemDTO.class))
                .orElse(null);
    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDTO) {
        Item item = modelMapper.map(itemDTO, Item.class);
        Item updatedItem = itemRepository.save(item);
        return modelMapper.map(updatedItem, ItemDTO.class);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}