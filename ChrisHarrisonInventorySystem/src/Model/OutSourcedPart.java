
package Model;

/**
 *
 * @author chris
 */
public class OutSourcedPart extends Part{
    private String companyName;

    public OutSourcedPart(String companyName, int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
        
         setId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
        
        this.companyName = companyName;
    }    
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getCompanyName() {
        return this.companyName;
    }
}
