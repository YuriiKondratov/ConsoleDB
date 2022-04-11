package database;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Table {
    private int id;
    private final HashMap<Integer, Record> table;

    {
        id = 0;
    }

    public Table() {
        this.table = new HashMap<>();
    }

    public int insert (Record rec) {
        if (this.table.containsValue(rec)) return 0;
        this.id++;
        this.table.put(id, rec);
        return id;
    }

    public Record delete(int id) {
        return table.remove(id);
    }

    public Set<Map.Entry<Integer, Record>> getAll() {
        return this.table.entrySet();
    }

    public Record getOne(int id) {
        return this.table.get(id);
    }

    public int size() {
        return this.table.size();
    }
}
