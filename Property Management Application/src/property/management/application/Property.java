package property.management.application;
/**
 *
 * @author MD SHAMIM
 */
public class Property {
    private String Name;
    private int Id;
    private int Index;
    public Property(String Name, int Id, int Index)
    {
        this.Name = Name;
        this.Id = Id;
        this.Index = Index;
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return Id;
    }

    public int getIndex() {
        return Index;
    }

    @Override
    public String toString() {
        return Name;
    }
    
}
