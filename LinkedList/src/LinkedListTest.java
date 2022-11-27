import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	public LinkedList sll;
	@Before
	public void setUp() throws Exception {
		sll = new LinkedList();
	}

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	@Test
    public void testHeadForNull() {
        assertNull(sll.head);
    }
	@Test
    public void testHeadForNode() {
        sll.add(8);
        assertNotNull(sll.head);
    }
	@Test
    public void testHeadNextVal() {
        sll.add(5);
        sll.add(10);
        assertTrue(sll.head.next.data == 10);
    }
	@Test
    public void testHeadAfterRemove() {
        sll.add(10);
        sll.removeFront();
        assertNull(sll.head);
    }
}
