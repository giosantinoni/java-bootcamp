package exercise;

import java.util.ArrayList;
import java.util.List;

public class WordWrapping implements IWordWrapping {

	@Override
	public List<String> wrapText(String text, int rowLength) {
		List<String> textWrapped = new ArrayList<String>();

		if (text.length() <= rowLength)
			textWrapped.add(text);
		else {
			String[] aux = text.split(" ");
			int i = 0;

			if (aux.length == 1) {
				int begin = 0;
				int end = rowLength;
				int wordLength = aux[0].length();
				
				while (begin < wordLength) {
					textWrapped.add(aux[0].substring(begin, end));
					
					begin = end;	
					
					if (end + wordLength < wordLength)
						end += rowLength;
					else
						end = wordLength;					
				}
			} else {
				while (i < aux.length) {
					if (i + 1 < aux.length)
						if (aux[i].length() < rowLength && (aux[i].length() + aux[i + 1].length()) < rowLength) {
							textWrapped.add(aux[i] + " " + aux[i + 1]);
							i++;
						} else
							textWrapped.add(aux[i]);
					else
						textWrapped.add(aux[i]);
					i++;
				}
			}
		}

		return textWrapped;
	}

}
