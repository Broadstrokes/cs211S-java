import java.math.BigDecimal;
import java.util.Date;

public interface Account {
    public String getUserId();
    public String getAccountId();
    public BigDecimal getBalance();
    public Date getAccountOpeningDate();
}
