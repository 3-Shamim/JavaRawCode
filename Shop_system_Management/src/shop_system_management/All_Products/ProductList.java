package shop_system_management.All_Products;

/**
 *
 * @author MD SHAMIM
 */
public class ProductList {
    private final String Name;
    private final String Type;
    private final String Date;
    private final int Remain;
    private final int Id;
    private final int Index;
    public ProductList(int Id,String Name, String Type,int Remain,String Date,int Index)
    {
        this.Id = Id;
        this.Name = Name;
        this.Type = Type;
        this.Remain = Remain;
        this.Date = Date;
        this.Index = Index;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public String getDate() {
        return Date;
    }

    public int getRemain() {
        return Remain;
    }

    public int getId() {
        return Id;
    }

    public int getIndex() {
        return Index;
    }

}
