
// Create a new Spring Boot application in java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}


// create crud functionality for a rest api in java
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private List<Item> items = new ArrayList<>();

    @GetMapping
    public List<Item> getAllItems() {
        return items;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id) {
        Optional<Item> item = items.stream().filter(i -> i.getId() == id).findFirst();
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Item createItem(@RequestBody Item newItem) {
        items.add(newItem);
        return newItem;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item updatedItem) {
        Optional<Item> existingItem = items.stream().filter(i -> i.getId() == id).findFirst();
        if (existingItem.isPresent()) {
            items.remove(existingItem.get());
            items.add(updatedItem);
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id) {
        Optional<Item> existingItem = items.stream().filter(i -> i.getId() == id).findFirst();
        if (existingItem.isPresent()) {
            items.remove(existingItem.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

class Item {
    private int id;
    private String name;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}