import java.util.Objects;

public class EvictionNotice implements Comparable<EvictionNotice> {

    private String id, zip, neighborhood, filingDate;
    private boolean illegalUse;


    /*
        Constructors
     */


    public EvictionNotice(String id, String zip, String neighborhood, boolean illegalUse, String filingDate) {
        this.id = id;
        this.zip = zip;
        this.neighborhood = neighborhood;
        this.illegalUse = illegalUse;
        this.filingDate = filingDate;
    }


    /*
        Getters & Setters
     */


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public boolean isIllegalUse() {
        return illegalUse;
    }

    public void setIllegalUse(boolean illegalUse) {
        this.illegalUse = illegalUse;
    }

    public String getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate;
    }


    /*
        Overrides
     */


    @Override
    public String toString() {
        return "EvictionNotice{" +
                "id='" + id + '\'' +
                ", zip='" + zip + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", illegalUse=" + illegalUse +
                ", filingDate=" + filingDate +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        EvictionNotice that = (EvictionNotice) other;
        return illegalUse == that.illegalUse &&
                Objects.equals(id, that.id) &&
                Objects.equals(zip, that.zip) &&
                Objects.equals(neighborhood, that.neighborhood) &&
                Objects.equals(filingDate, that.filingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zip, neighborhood, illegalUse, filingDate);
    }

    @Override
    public int compareTo(EvictionNotice other) {
        return id.compareTo(other.id);
    }
}
