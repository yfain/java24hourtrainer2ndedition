

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by yfain11 on 4/4/14.
 */
public class Bid implements Serializable {
    public int id;
    public Product product;
    public BigDecimal amount;
    public int desiredQuantity; // How many items the user wants
    public User user;
    public LocalDateTime bidTime;
    public boolean isWinning;
}
