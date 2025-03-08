package edu.icet.ecom.controller;

import edu.icet.ecom.dto.ItemDTO;
import edu.icet.ecom.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
@CrossOrigin
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDTO> addItem(@RequestBody ItemDTO itemDTO) {
        if (itemDTO.getImage() == null || itemDTO.getImage().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ItemDTO createdItem = itemService.addItem(itemDTO);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        ItemDTO item = itemService.searchById(id);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        System.out.println("Received PUT request for item id: " + id + " with data: " + itemDTO);

        if (id == null || !id.equals(itemDTO.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (itemDTO.getName() == null || itemDTO.getPrice() == 0 || itemDTO.getCategory() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (itemDTO.getImage() == null || itemDTO.getImage().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ItemDTO updatedItem = itemService.updateItem(itemDTO);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
