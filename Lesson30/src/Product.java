

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by yfain11 on 4/4/14.
 */
public class Product implements Serializable {
    public int id;
    public String title;
    public String thumb;
    public String description;
    public int quantity;   // How many items the seller has
    public LocalDateTime auctionEndTime;
    public int watchers;
    public BigDecimal minimalPrice;     // Don't sell unless the bid is more than min price
    public BigDecimal reservedPrice;   // If a bidder offers reserved price, the auction is closed
}
