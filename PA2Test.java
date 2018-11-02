import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


public class PA2Test {
	
	private LinkedStack<Queue<Character>> stack = new LinkedStack<>();
	private ArrayQueue<Character> q = new ArrayQueue<>(10);


	@Test
	public void testReadSentences() { // Notepad \n Format \n 123456 \n ABCDEFG
		System.out.println("\n********************************\n"
				+ "TEST READ SENTENCES:\n");
		
		// expected output:
		Character notepad[] = {'N','o','t','e','p','a','d'};
		Character format[] = {'F','o','r','m','a','t'};
		Character nums[] = {'1','2','3','4','5','6'};
		Character alphas[] = {'A','B','C','D','E','F','G'};
		
		// reading from file
		stack = (LinkedStack<Queue<Character>>) SimpleEncrypt.readSentences("sentences.data");
		
		stack.display();
		
		ArrayQueue<Character> q1 =  (ArrayQueue<Character>) stack.pop(); // pop the first queue from the stack
		Character a[] = new Character[q1.length()]; //actual output
		q1.multiServe(a, a.length); // moving the queue elements into a[].
		
		// checking if (actual output) = (expected output)
		for(int j=0; j<a.length; j++)
			assertEquals(notepad[j], a[j]);
		
		
		// repeat for the other sentences
		ArrayQueue<Character> q2 =  (ArrayQueue<Character>) stack.pop();
		Character b[] = new Character[q2.length()];
		q2.multiServe(b, b.length);
		
		for(int i=0; i<b.length; i++)
			assertEquals(format[i], b[i]);
		
		
		ArrayQueue<Character> q3 =  (ArrayQueue<Character>) stack.pop();
		Character c[] = new Character[q3.length()];
		q3.multiServe(c, c.length);
		
		for(int i=0; i<c.length; i++)
			assertEquals(nums[i], c[i]);
		
		ArrayQueue<Character> q4 =  (ArrayQueue<Character>) stack.pop();
		Character d[] = new Character[q4.length()];
		q4.multiServe(d, d.length);
		
		for(int i=0; i<d.length; i++)
			assertEquals(alphas[i], d[i]);

	}


	@Test
	public void testEncryptQueue() {
		System.out.println("\n********************************\n"
				+ "TEST ENCRYPT QUEUE:\n");
		
		int k=4; // the key for encrypting (you may change this, but you'll get a failure ; remember:(k>0) )

		Character nums[] =         {'0','1','2','3','4','5','6','7','8','9'}; // data to be encrypted
		Character expectedNums[] = {'3','2','1','0','7','6','5','4','9','8'}; // expected encrypted data
		
		q.multiEnqueue(nums, 10); // enqueue nums[] to q
		
		System.out.println("queue before encrypting:  (k="+k+")");
		q.display();
		
		SimpleEncrypt.encrypt(q, k); // encrypt q
		
		System.out.println("\nqueue after encrypting:  (k="+k+")");
		q.display();
		
		Character a[] = new Character[q.length()];
		q.multiServe(a, a.length); //actual output
		
		// checking if (actual output) = (expected output)
		for(int i=0; i<a.length; i++)
			assertEquals(expectedNums[i], a[i]);

}
	
	@Test
	public void testDecryptQueue() {
		int k=4; // the key for decrypting
		
		// encrypted elements:
		Character nums[] = {'3','2','1','0','7','6','5','4','9','8'};
		q.multiEnqueue(nums, 10);
		
		SimpleEncrypt.encrypt(q, k);
		
		Character a[] = new Character[q.length()]; 
		q.multiServe(a, a.length);
		
		// a[] should be = {'0','1','2','3','4','5','6','7','8','9'}
		
		char c = '0';
		for(int i=0; i<10; i++) {
			assertEquals((Character)c, a[i]);
			c = (char) (++c);			
		}	
	}
	
	@Test
	public void testEncryptStack() {
		System.out.println("\n********************************\n"
				+ "TEST ENCRYPT STACK:\n");
		int k=4; // the key for encrypting
		
		// characters[] to be enqueued in queues:
		Character notepad[] = {'N','o','t','e','p','a','d'};
		Character format[] = {'F','o','r','m','a','t'};
		Character nums[] = {'1','2','3','4','5','6'};
		Character alphas[] = {'A','B','C','D','E','F','G'};
		
		// ArrayQueues to be pushed in the stack:
		ArrayQueue<Character> QNotepad = new ArrayQueue<>(notepad.length);
		ArrayQueue<Character> QFormat = new ArrayQueue<>(format.length);
		ArrayQueue<Character> Qnums = new ArrayQueue<>(nums.length);
		ArrayQueue<Character> QAlphas = new ArrayQueue<>(alphas.length);
		
		// enqueueing Characters[] to queues:
		QNotepad.multiEnqueue(notepad, notepad.length);
		QFormat.multiEnqueue(format, format.length);
		Qnums.multiEnqueue(nums, nums.length);
		QAlphas.multiEnqueue(alphas, alphas.length);
		
		// pushing queues to the stack:
		stack.push(QAlphas);
		stack.push(Qnums);
		stack.push(QFormat);
		stack.push(QNotepad);
		
		System.out.println("Stack before encryption:  (k="+k+")");
		stack.display();
		
		SimpleEncrypt.encrypt(stack, k); // encrypting
		
		System.out.println("\nStack after encryption:  (k="+k+")");
		stack.display();
		
		// expected queues after encryption:
		Character expectedNotepad[] = {'e','t','o','N','d','a','p'};
		Character expectedFormat[] = {'m','r','o','F','t','a'};
		Character expectedNums[] = {'4','3','2','1','6','5'};
		Character expectedAlphas[] = {'D','C','B','A','G','F','E'};
		
		// testing if the encrypted stack results are the same as the expected queues above
		stack.pop().multiServe(notepad, notepad.length);
		for(int i=0; i<notepad.length; i++)
			assertEquals(expectedNotepad[i], notepad[i]);
		
		stack.pop().multiServe(format, format.length);
		for(int i=0; i<format.length; i++)
			assertEquals(expectedFormat[i], format[i]);
		
		stack.pop().multiServe(nums, nums.length);
		for(int i=0; i<nums.length; i++)
			assertEquals(expectedNums[i], nums[i]);
		
		stack.pop().multiServe(alphas, alphas.length);
		for(int i=0; i<alphas.length; i++)
			assertEquals(expectedAlphas[i], alphas[i]);
		
	}
	
	@Test
	public void testDecryptStack() {
		System.out.println("\n********************************\n"
				+ "TEST DECRYPT STACK:\n");
		int k=4; // the key for decrypting (you may change this ; remember:(k>0) )

		// characters[] to be enqueued in queues:
		Character notepad[] = {'e','t','o','N','d','a','p'};
		Character format[] = {'m','r','o','F','t','a'};
		Character nums[] = {'4','3','2','1','6','5'};
		Character alphas[] = {'D','C','B','A','G','F','E'};
		
		// ArrayQueues to be pushed in the stack:
		ArrayQueue<Character> QNotepad = new ArrayQueue<>(notepad.length);
		ArrayQueue<Character> QFormat = new ArrayQueue<>(format.length);
		ArrayQueue<Character> Qnums = new ArrayQueue<>(nums.length);
		ArrayQueue<Character> QAlphas = new ArrayQueue<>(alphas.length);
		
		// enqueueing Characters[] to queues:
		QNotepad.multiEnqueue(notepad, notepad.length);
		QFormat.multiEnqueue(format, format.length);
		Qnums.multiEnqueue(nums, nums.length);
		QAlphas.multiEnqueue(alphas, alphas.length);
		
		// pushing queues to the stack:
		stack.push(QAlphas);
		stack.push(Qnums);
		stack.push(QFormat);
		stack.push(QNotepad);
		
		System.out.println("Encrypted stack:");
		stack.display();
		
		SimpleEncrypt.decrypt(stack, k); // decrypting
		
		System.out.println("\nDecrypted stack");
		stack.display();
		
		// expected queues after decryption:

		Character expectedNotepad[] = {'N','o','t','e','p','a','d'};
		Character expectedFormat[] = {'F','o','r','m','a','t'};
		Character expectedNums[] = {'1','2','3','4','5','6'};
		Character expectedAlphas[] = {'A','B','C','D','E','F','G'};
		
		// testing if the encrypted stack results are the same as the expected queues above
		stack.pop().multiServe(notepad, notepad.length);
		for(int i=0; i<notepad.length; i++)
			assertEquals(expectedNotepad[i], notepad[i]);
		
		stack.pop().multiServe(format, format.length);
		for(int i=0; i<format.length; i++)
			assertEquals(expectedFormat[i], format[i]);
		
		stack.pop().multiServe(nums, nums.length);
		for(int i=0; i<nums.length; i++)
			assertEquals(expectedNums[i], nums[i]);
		
		stack.pop().multiServe(alphas, alphas.length);
		for(int i=0; i<alphas.length; i++)
			assertEquals(expectedAlphas[i], alphas[i]);

		
	}
	
}