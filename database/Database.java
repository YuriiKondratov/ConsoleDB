package database;

import java.util.*;

public class Database {
    private final HashMap<String, Table> tables;

    public Database() {
        tables = new HashMap<>();
    }

    public List<Integer> insert(String tablename, Record... records) throws ConcurrentModificationException{
        int id;
        List<Integer> ids = new ArrayList<>();
        Table t = tables.get(tablename);
        if (t == null) t = new Table();
        for (Record rec : records) {
            id = t.insert(rec);
            if (id == 0) throw new ConcurrentModificationException("Same record already exists");
            ids.add(id);
        }
        tables.put(tablename, t);
        return ids;
    }

    public Record deleteRec(String tablename, int id) {
        Table t = tables.get(tablename);
        if (t == null) return null;
        return t.delete(id);
    }

    public boolean deleteTable(String tablename) {
        Table t = tables.get(tablename);
        return t != null;
    }

    public Set<Map.Entry<Integer, Record>> getTableContent(String tablename) {
        Table t = tables.get(tablename);
        if (t == null) return null;
        return t.getAll();
    }

    public Record getRow(String tablename, int id) {
        Table t = tables.get(tablename);
        if (t == null) return null;
        return t.getOne(id);
    }
}

