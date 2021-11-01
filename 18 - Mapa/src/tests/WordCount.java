package tests;
import java.io.IOException;
import java.util.Scanner;
import commons.Entry;
import source.HashTableMap;

class WordCount {
	public static void main(String[] args) throws IOException {
		String texto = "O Brasil, um vasto pais sul-americano, estende-se da Bacia Amazonica, no norte, ate os vinhedos “
		+ "e as gigantescas Cataratas do Iguacu, no sul. O Rio de Janeiro, simbolizado pela sua estatua de 38 metros de altura "
		+ "do Cristo Redentor, situada no topo do Corcovado, e famoso pelas movimentadas praias de Copacabana e Ipanema, "
		+ "bem como pelo imenso e animado Carnaval, com desfiles de carros alegoricos, fantasias extravagantes e samba.\r\n"
		+ "O Brasil e um pais localizado no subcontinente da America do Sul. O territorio brasileiro e banhado pelo oceano "
		+ "Atlantico, limitando-se ao norte, com a Guiana Francesa, Suriname, Guiana, Venezuela e Colombia; a noroeste, "
		+ "com o Peru; a oeste, com a Bolivia, Paraguai e Argentina; e ao sul, com o Uruguai. O Brasil é lindo"; 
		Scanner doc = new Scanner(texto); 
		doc.useDelimiter("[^a-zA-Z]");
		HashTableMap<String,Integer> h = new HashTableMap<String,Integer>(); 
		String word; 
		Integer count; 
		while (doc.hasNext()) { 
			word = doc.next(); 
			if (word.equals("")) continue;
			if (word.length()<=3) continue; 
			word = word.toLowerCase();
			count = h.get(word); 
			if (count == null) h.put(word, 1);
			else h.put(word, ++count); 
		}
		int maxCount = 0; 
		String maxWord = "sem palavras"; 
		for (Entry<String,Integer> ent : h.entrySet()) {
			if (ent.getValue() > maxCount) { 
				maxWord = ent.getKey(); 
				maxCount = ent.getValue(); 
			} 
		} 
		System.out.print("A palavra mais frequente é \"" + maxWord); 
		System.out.println(",\" com um total de ocorrências = " + maxCount + ".");
		doc.close();
	}
}
