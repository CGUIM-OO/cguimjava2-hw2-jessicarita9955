import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here
 * B0344135 ���۽@
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 
	 * @param nDeck
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		for(int x=0; x<nDeck; x++) {
			for(int y=1; y<=4; y++) {
				for(int z=1; z<=13; z++) {
					//System.out.prinln(y+","+k);
					Card card = new Card(y, z);
					cards.add(card);					
				}
			}
		}
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		for(int i=0; i<cards.size(); i++) {
			Card printDeck = cards.get(i);
			printDeck.printCard();			
		}
		System.out.println(cards.size());
		//TODO: please implement and reuse printCard method in Card class (5 points)

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		String Suit="";
		String Rank="";
		switch(suit) {
			case 1: Suit="Clubs";
			break;
			case 2: Suit="Diamonds";
			break;
			case 3: Suit="Hearts";
			break;
			case 4: Suit="Spades";
			break;			
		}		
		switch(rank) {
			case 1: Rank="Ace";
			break;
			case 2: Rank="2";
			break;
			case 3: Rank="3";
			break;
			case 4: Rank="4";
			break;
			case 5: Rank="5";
			break;
			case 6: Rank="6";
			break;
			case 7: Rank="7";
			break;
			case 8: Rank="8";
			break;
			case 9: Rank="9";
			break;
			case 10: Rank="10";
			break;
			case 11: Rank="J";
			break;
			case 12: Rank="Q";
			break;
			case 13: Rank="K";
			break;
		}
		System.out.println(Suit+","+Rank);
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
