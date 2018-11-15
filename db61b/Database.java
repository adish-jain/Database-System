package db61b;

import java.util.TreeMap;

/** A collection of Tables, indexed by name.
 *  @author Adish Jain*/
class Database {
    /** An empty database. */
    public Database() {
        _tables = new TreeMap<String, Table>();
    }

    /** Return the Table whose name is NAME stored in this database, or null
     *  if there is no such table. */
    public Table get(String name) {
        if (_tables.containsKey(name)) {
            return _tables.get(name);
        }
        return null;
    }

    /** Set or replace the table named NAME in THIS to TABLE.  TABLE and
     *  NAME must not be null, and NAME must be a valid name for a table. */
    public void put(String name, Table table) {
        if (name == null || table == null) {
            throw new IllegalArgumentException("null argument");
        }
        if (name.matches("^[A-Za-z0-9_]+$")
                && name.indexOf(0) != '0'
                && name.indexOf(0) != '1'
                && name.indexOf(0) != '2'
                && name.indexOf(0) != '3'
                && name.indexOf(0) != '4'
                && name.indexOf(0) != '5'
                && name.indexOf(0) != '6'
                && name.indexOf(0) != '7'
                && name.indexOf(0) != '8'
                && name.indexOf(0) != '9') {
            _tables.put(name, table);
        }
    }

    /**
     * A treeMap data structure that acts as our database.
     */
    private TreeMap<String, Table> _tables;
}
