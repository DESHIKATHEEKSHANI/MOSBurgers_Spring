package edu.icet.ecom.service;

import edu.icet.ecom.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO addItem(ItemDTO itemDTO);
    List<ItemDTO> getAll();
    ItemDTO searchById(Long id);
    ItemDTO updateItem(ItemDTO itemDTO);
    void deleteItem(Long id);
}