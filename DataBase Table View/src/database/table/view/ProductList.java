package database.table.view;

/**
 *
 * @author MD SHAMIM
 */
public class ProductList {
    private String Name;
    private String Type;
    private String Date;
    private int Remain;
    private int Id;
    private int Index;
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
