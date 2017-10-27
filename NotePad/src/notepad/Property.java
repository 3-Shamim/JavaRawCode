package notepad;
/**
 *
 * @author MD SHAMIM
 */
public class Property {
   
    private String Ownername;
    private int OwnerId;
    private int OwnerIndex;
    public Property(String name, int id, int Index)
    {
        Ownername = name;
        OwnerId = id;
        OwnerIndex = Index;
    }

    public String getOwnername() 
    {
        return Ownername;
    }

    public int getOwnerId() 
    {
        return OwnerId;
    }
    

    @Override
    public String toString() {
        return "Ownername = " + Ownername + "  OwnerId = " + OwnerId;
    }

    public int getOwnerIndex() {
        return OwnerIndex;
    }

    
    
    
}
