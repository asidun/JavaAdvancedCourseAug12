import com.flowergarden.bouquet.MarriedBouquet;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by olena.kruchina on 8/29/2017.
 */
public class MarriedBouquetTest {

    private MarriedBouquet bouquet = new MarriedBouquet();

    @Before
    public void makeBouquet() {
        bouquet.addFlower(new Rose(true, 15, 15, new FreshnessInteger(1)));
        bouquet.addFlower(new Rose(true, 25, 25, new FreshnessInteger(2)));
        bouquet.addFlower(new Rose(true, 5, 5, new FreshnessInteger(2)));
        bouquet.addFlower(new Rose(true, 2, 2, new FreshnessInteger(2)));
        bouquet.addFlower(new Rose(true, 10, 10, new FreshnessInteger(2)));
    }

    @Test
    public void searchFlowerByLengthTest() {
        //given
        Collection<GeneralFlower> expectedFlowers = new ArrayList<>();
        expectedFlowers.add(new Rose(true, 15, 15, new FreshnessInteger(1)));
        expectedFlowers.add(new Rose(true, 25, 25, new FreshnessInteger(1)));

        //when
        Collection actualFlowers = bouquet.searchFlowersByLenght(15, 26);

        //then
        Assert.assertEquals("not equal", expectedFlowers, actualFlowers); //need to override equals()
    }
}
