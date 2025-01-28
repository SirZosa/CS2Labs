class Concert {
	private int id;
	String Artist;
	private int capacity;

	/*
	 * 24-hour format without a
	 * colon, 8:00 am is 800, 5:30 pm
	 * is 1730
	 */
	private int startTime;
	private int endTime;

	Concert(int i, int s, int e) {
		id = i;
		startTime = s;
		endTime = e;
	}

	Concert(int i, String artist, int c, int s, int e) {
		id = i;
		Artist = artist;
		capacity = c;
		startTime = s;
		endTime = e;
	}

	private int getConcertLength() {
		return endTime - startTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getArtist() {
		return Artist;
	}

	public void setCapacity(int c) {
		capacity = c;
	}

	public int getDuration() {
        return endTime - startTime;
    }

	public String toString() {
		return String.format(
			
			"| %-5s | %-20s | %-8s | %-10s | %-8s | %-8s |%n", 
					id ,    
					Artist ,    
					capacity ,    
					startTime,    
					endTime,
					getConcertLength()
           
        );
		
	}

}