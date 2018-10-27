package enums;


/** to be used in priority queue. */
public enum Priority {
	
	VERY_LOW(0),
	LOW(3),
	MEDIUM(6),
	HIGH(9),
	VERY_HIGH(12);
	
	private final int value;
	
	private Priority(int value) {
		this.value = value;
	}
    /**
     * Compares two {@code Priorty} values numerically.
     * @param {@code Priorty} that
	 *
     * @return the value {@code 0} if {@code this == that};
     *         a value less than {@code 0} if {@code this < that}; and
     *         a value greater than {@code 0} if {@code this > that}
     */
	public int compare(Priority that) {
		return Integer.compare(this.value, that.value);
	}
	
}
