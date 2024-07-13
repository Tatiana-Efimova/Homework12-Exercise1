import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void testDeleteIfProductExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "персики", 200);
        Product product2 = new Product(2, "черешня", 400);
        Product product3 = new Product(3, "яблоки", 100);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testDeleteIfProductDoesntExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "персики", 200);
        Product product2 = new Product(2, "черешня", 400);
        Product product3 = new Product(3, "яблоки", 100);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

//        repo.remove(123);
//        Product[] actual = repo.findAll();
//        Product[] expected = {product1, product2, product3};
//        Assertions.assertArrayEquals(expected, actual);
//   если есть исключение NotFoundException, то тест пройден

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(123)
        );

    }

}
