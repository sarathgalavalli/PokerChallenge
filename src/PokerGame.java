

 import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;



public class PokerGame {
	final static String faces = "23456789TJQKA";
    final static String suits = "DHCS";
 
    public static void main(String[] args) {
    	String twoHands;
    	BufferedReader br;
    	int playerOne = 0 ;
        int playerTwo = 0;
       
    	
    	
		try {
			br = new BufferedReader(new FileReader("poker-hands.txt"));
		
			while ((twoHands = br.readLine()) != null){
				String playerOneString = twoHands.substring(0,twoHands.length()/2);
				String playerTwoString = twoHands.substring(twoHands.length()/2+1,twoHands.length());
				Integer playerOneScore = handScore(playerOneString.split(" "));
				Integer playerTwoScore = handScore(playerTwoString.split(" "));
				
				if(playerOneScore > playerTwoScore) {
					playerOne = playerOne + 1;
				}else if((playerTwoScore) > playerOneScore) {
					playerTwo = playerTwo + 1;
				}else if (playerOneScore == playerTwoScore) {
					
                     int score = tieBreaker(playerOneString.split(" "), playerTwoString.split(" "),playerOneScore);  
                     if(score == 1) {
                    	 playerOne = playerOne + 1;
                     }else if(score == 0) {
                    	 playerTwo = playerTwo + 1; 
                     }
					
				}	
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println(playerOne);
			System.out.println(playerTwo);
			
		}

    	
    	
    	
    }
        
        private static Integer handScore(final String[] hand) {
     
            int[] faceCount = new int[faces.length()];
            long straightHand = 0, flush = 0;
            for (String card : hand) {
     
                int face = faces.indexOf(card.charAt(0));
                
                straightHand |= (1 << face);
     
                faceCount[face]++;
     
                flush |= (1 << card.charAt(1));
            }
     
          
            while (straightHand % 2 == 0)
            	straightHand >>= 1;
     
          
            boolean hasStraight = straightHand == 0b11111 ;
     
           
            boolean hasFlush = (flush & (flush - 1)) == 0;
     
            if (hasStraight && hasFlush)
                return 9;
     
            int total = 0;
            for (int count : faceCount) {
                if (count == 4)
                    return 8;
                if (count == 3)
                    total += 3;
                else if (count == 2)
                    total += 2;
            }
     
            if (total == 5)
                return 7;
     
            if (hasFlush)
                return 6;
     
            if (hasStraight)
                return 5;
     
            if (total == 3)
                return 4;
     
            if (total == 4)
                return 3;
     
            if (total == 2)
                return 2;
     
            return 1;
        }
       
        private static int tieBreaker(final String[] player1, final String[] player2, final int score) {
        	
        	ArrayList<Integer> oneList = new ArrayList<Integer>();
    		ArrayList<Integer> twoList = new ArrayList<Integer>();
    		for (String card : player1) {
    			if(card.charAt(0) == 'T')
    			{
    				 oneList.add(10); 
    			}else if (card.charAt(0) == 'J')
    			{
    				oneList.add(11); 
    			}else if (card.charAt(0) == 'Q')
    			{
    				oneList.add(12); 
    			}else if (card.charAt(0) == 'K')
    			{
    				oneList.add(13); 
    			}
    			else if (card.charAt(0) == 'A')
    			{
    				oneList.add(14); 
    			}
    			else if (card.charAt(0) == '9')
    			{
    				oneList.add(9); 
    			}else if (card.charAt(0) == '8')
    			{
    				oneList.add(8); 
    			}else if (card.charAt(0) == '7')
    			{
    				oneList.add(7); 
    			}
    			else if (card.charAt(0) == '6')
    			{
    				oneList.add(6); 
    			}
    			else if (card.charAt(0) == '5')
    			{
    				oneList.add(5); 
    			}else if (card.charAt(0) == '4')
    			{
    				oneList.add(4); 
    			}else if (card.charAt(0) == '3')
    			{
    				oneList.add(3); 
    			}
    			else if (card.charAt(0) == '2')
    			{
    				oneList.add(2); 
    			}
//    			}else {
//    				oneList.add((int)card.charAt(0));
//    				//System.out.println((int)card.charAt(0));
//    			}
            }
    		for (String card : player2) {
    			if(card.charAt(0) == 'T')
    			{
    				twoList.add(10); 
    			}else if (card.charAt(0) == 'J')
    			{
    				twoList.add(11); 
    			}else if (card.charAt(0) == 'Q')
    			{
    				twoList.add(12); 
    			}else if (card.charAt(0) == 'K')
    			{
    				twoList.add(13); 
    			}
    			else if (card.charAt(0) == 'A')
    			{
    				twoList.add(14); 
    			}else if (card.charAt(0) == '9')
    			{
    				twoList.add(9); 
    			}else if (card.charAt(0) == '8')
    			{
    				twoList.add(8); 
    			}else if (card.charAt(0) == '7')
    			{
    				twoList.add(7); 
    			}
    			else if (card.charAt(0) == '6')
    			{
    				twoList.add(6); 
    			}
    			else if (card.charAt(0) == '5')
    			{
    				twoList.add(5); 
    			}else if (card.charAt(0) == '4')
    			{
    				twoList.add(4); 
    			}else if (card.charAt(0) == '3')
    			{
    				twoList.add(3); 
    			}
    			else if (card.charAt(0) == '2')
    			{
    				twoList.add(2); 
    			}
            }
    		Collections.sort(oneList);
    		Collections.sort(twoList);
    		
    		ArrayList<Integer> newList1 = new ArrayList<Integer>(); 
   		    ArrayList<Integer> newList2 = new ArrayList<Integer>(); 
   		    
   		 ArrayList<Integer> compareList1 = new ArrayList<Integer>(); 
		    ArrayList<Integer> compareList2 = new ArrayList<Integer>(); 
	        
	        for (int element : oneList) { 
	  
	           
	            if (newList1.contains(element)) { 
	            	compareList1.add(element);
	               
	            } else {
	            	 newList1.add(element); 
	            }
	        } 
	        
	       for (int element : twoList) { 
	     	  
	           
	            if (newList2.contains(element)) { 
	            	compareList2.add(element);
	               
	            } else {
	            	 newList2.add(element); 
	            }
	        } 
	       
	      Collections.sort(newList1);
 		  Collections.sort(newList2);
 		  Collections.sort(compareList1);
 		  Collections.sort(compareList2);
    		
    		 
			if (score == 1 || score == 5 || score == 9 || score ==6) {
				/*considering flush has all 5 different cards*/

				if ((oneList.get(4) > twoList.get(4)) && (oneList.get(4) != twoList.get(4))) {
					return 1;
				
				} else if ((oneList.get(3) > twoList.get(3)) && (oneList.get(4) == twoList.get(4))) {
					return 1;
				}  else if ((oneList.get(2) > twoList.get(2)) && (oneList.get(3) == twoList.get(3))
						&& (oneList.get(4) == twoList.get(4))) {
					return 1;
				} 

				else if ((oneList.get(1) > twoList.get(1)) && (oneList.get(2) == twoList.get(2))
						&& (oneList.get(3) == twoList.get(3)) && (oneList.get(4) == twoList.get(4))) {
					return 1;
				} 

				else if ((oneList.get(0) > twoList.get(0)) && (oneList.get(1) == twoList.get(1))
						&& (oneList.get(2) == twoList.get(2)) && (oneList.get(3) == twoList.get(3))
						&& (oneList.get(4) == twoList.get(4))) {
					return 1;
				} else 
					return 0;
				

			}

			if (score == 2 || score ==4 || score ==8) {
				
				if(compareList1.get(0)  > compareList2.get(0)) {
					return 1;
				}else if (compareList2.get(0)  > compareList1.get(0)) {
					return 0;
				}
				
				if(score ==2) {
	  		  
				if ((newList1.get(3) > newList2.get(3)) && (newList1.get(3) != newList2.get(3))) {
					return 1;
				}  else if ((newList1.get(2) > twoList.get(2)) && (newList1.get(3) == newList2.get(3))) {
					return 1;
				}

				else if ((newList1.get(1) > newList2.get(1)) && (newList1.get(2) == newList2.get(2))
						&& (newList1.get(3) == newList2.get(3))) {
					return 1;
				} 

				else if ((newList1.get(0) > newList2.get(0)) && (newList1.get(1) == newList2.get(1))
						&& (newList1.get(2) == newList2.get(2)) && (newList1.get(3) == newList2.get(3))) {
					return 1;
				} else
					return 0;
				}else if (score ==4) {
					if ((newList1.get(2) > twoList.get(2)) ) {
						return 1;
					} else if ((newList2.get(2) > newList1.get(2)) ) {
						return 0;
					}

					else if ((newList1.get(1) > newList2.get(1)) && (newList1.get(2) == newList2.get(2))
							) {
						return 1;
					} 
					else if ((newList1.get(0) > newList2.get(0)) && (newList1.get(1) == newList2.get(1))
							&& (newList1.get(2) == newList2.get(2)) ) {
						return 1;
					} else
						return 0;
					}else if (score == 8) {
						if ((newList1.get(1) > newList2.get(1)) 
								) {
							return 1;
						} else if ((newList1.get(0) > newList2.get(0)) && (newList1.get(1) == newList2.get(1))
								 ) {
							return 1;
						} else
							return 0;
						}
						
					}
					
				
			


			if (score == 3 || score ==7 ) {
				if (compareList1.get(1) > compareList2.get(1)) {
					return 1;
				} else if (compareList2.get(1) > compareList1.get(1)) {
					return 0;
				} else if ((compareList1.get(0) > compareList2.get(0))
						&& (compareList2.get(1) == compareList1.get(1))) {
					return 1;
				} else if ((compareList2.get(0) > compareList1.get(0))
						&& (compareList2.get(1) == compareList1.get(1))) {
					return 0;
				}
				
				
				
				if(score ==3 ) {
				if ((newList1.get(2) > twoList.get(2))) {
					return 1;
				} 

				else if ((newList1.get(1) > newList2.get(1)) && (newList1.get(2) == newList2.get(2))) {
					return 1;
				} 

				else if ((newList1.get(0) > newList2.get(0)) && (newList1.get(1) == newList2.get(1))
						&& (newList1.get(2) == newList2.get(2))) {
					return 1;
				} else
					return 0;
				}else if (score ==7) {
					if ((newList1.get(1) > newList2.get(1)) ) {
						return 1;
					} else if ((newList2.get(1) > newList1.get(1)) ) {
						return 0;
					}

					else if ((newList1.get(0) > newList2.get(0)) && (newList1.get(1) == newList2.get(1))
							&& (newList1.get(2) == newList2.get(2))) {
						return 1;
					} else
						return 0;
					}
					
				}
			
		

			
			
			
			
			return 0;  
		}
}   
        
