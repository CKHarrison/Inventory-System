
package Model;

/**
 *
 * @author chris
 */
public class InHousePart extends Part {
    private int machineId;

    public InHousePart(int machineId, int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
        setId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
        this.machineId = machineId;
    }

    public int getMachineId() {
        return machineId;
    }

    
    
}
