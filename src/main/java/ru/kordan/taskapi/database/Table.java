package ru.kordan.taskapi.database;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class Table<Item> {
    private int id;
    private final Map<Integer, Item> table;

    public Table() {
        id = 0;
        table = new HashMap<>();
    }

    public Map.Entry<Integer, Item> insert (Item item) {
        if (table.containsValue(item)) return null;
        id++;
        table.put(id, item);
        return Map.entry(id, item);
    }

    public Item getOne(int id) {
        return table.get(id);
    }

    public Set<Map.Entry<Integer, Item>> getAll() {
        return table.entrySet();
    }

    public boolean update(int id, Item item){
        if (!table.containsKey(id)) return false;
        table.put(id, item);
        return true;
    }

    public Item delete(int id) {
        return table.remove(id);
    }

    public int size() {
        return table.size();
    }
}
