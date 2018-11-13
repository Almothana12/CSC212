import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PA3Test {

	BT<Integer> tree;
	
	@BeforeEach
	void setUp() throws Exception {
		tree = new LinkedBT<>();
	}

	@Test
	void testGetTree() {
		tree = Staircase.getTree(4, 1, 2);
		System.out.println(BTUtils.nbLeaf(tree, 4));
		BTNode<Integer> temp = tree.getRoot();
		assertEquals( Integer.valueOf(0), temp.data);
		temp = temp.left;
		assertEquals(Integer.valueOf(1), temp.data );
		temp = temp.left;
		assertEquals( Integer.valueOf(2), temp.data);
		temp = temp.left;
		assertEquals( Integer.valueOf(3), temp.data);
		temp = temp.left;
		assertEquals( Integer.valueOf(4), temp.data);
		if(temp.left != null)
			fail("left is not null. At temp="+temp.data);
		if(temp.right != null)
			fail("left is not null. At temp="+temp.data);
		
		temp = temp.parent;
		assertEquals(Integer.valueOf(3), temp.data );
		temp = temp.parent;
		assertEquals( Integer.valueOf(2), temp.data);
		temp = temp.right;
		assertEquals( Integer.valueOf(4), temp.data);
		if(temp.left != null)
			fail("left is not null. At temp="+temp.data);
		if(temp.right != null)
			fail("left is not null. At temp="+temp.data);
		
		temp = temp.parent;
		temp = temp.parent;
		temp = temp.right;
		assertEquals(Integer.valueOf(3), temp.data);
		temp = temp.left;
		assertEquals( Integer.valueOf(4), temp.data);
		
		temp = tree.getRoot();
		temp = temp.right;
		assertEquals(Integer.valueOf(2), temp.data );
		temp = temp.right;
		assertEquals(Integer.valueOf(4), temp.data );
		if(temp.left != null)
			fail("left is not null. At temp="+temp.data);
		if(temp.right != null)
			fail("left is not null. At temp="+temp.data);
		temp = temp.parent;
		temp = temp.left;
		assertEquals(Integer.valueOf(3), temp.data);
		temp = temp.left;
		assertEquals(Integer.valueOf(4), temp.data );
	}
	
	@Test
	void testGetTree2() {
		tree = Staircase.getTree(4, 2, 3);
		BTNode<Integer> temp = tree.getRoot();
		assertEquals(Integer.valueOf(0), temp.data);
		temp = temp.left;
		assertEquals(Integer.valueOf(2), temp.data);
		temp = temp.left;
		assertEquals(Integer.valueOf(4), temp.data);
		if(temp.left != null)
			fail("left is not null. At temp="+temp.data);
		if(temp.right != null)
			fail("left is not null. At temp="+temp.data);
		temp = tree.getRoot();
		temp = temp.right;
		assertEquals(Integer.valueOf(3), temp.data);
		if(temp.left != null)
			fail("left is not null. At temp="+temp.data);
		if(temp.right != null)
			fail("left is not null. At temp="+temp.data);
	}
	
	@Test
	void testGetTreeWithout() {
		tree = Staircase.getTreeWithout(4, 1, 2, 3);
		BTNode<Integer> temp = tree.getRoot();
		assertEquals(Integer.valueOf(0), temp.data);
		temp = temp.left;
		assertEquals(Integer.valueOf(1), temp.data);
		temp = temp.left;
		assertEquals(Integer.valueOf(2), temp.data);
		temp = temp.right;
		assertEquals(Integer.valueOf(4), temp.data);
		if(temp.left != null)
			fail("left is not null");
		if(temp.right != null)
			fail("left is not null");
		temp = tree.getRoot();
		temp = temp.right;
		assertEquals(Integer.valueOf(2), temp.data);
		temp = temp.right;
		assertEquals(Integer.valueOf(4), temp.data);
		if(temp.left != null)
			fail("left is not null.");
		if(temp.right != null)
			fail("left is not null.");
	}
	
	@Test
	void testGetNBSol() {
		int nbSol;
		nbSol = Staircase.getNbSol(4, 1, 2);
		assertEquals(5, nbSol);
		
		nbSol = Staircase.getNbSol(4, 2, 3);
		assertEquals(1, nbSol);
	}
	
	@Test
	void testGetNBSolWithout() {
		int nbSol;
		nbSol = Staircase.getNbSolWithout(4, 1, 2, 3);
		assertEquals(2, nbSol);
	}
	
	

}
