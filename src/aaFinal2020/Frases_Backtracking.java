package aaFinal2020;
import java.util.*;

public class Frases_Backtracking {
/*
 Dada una cadena de caracteres de tamaño N, construir todas las frases que se forman al permutar caracteres en ella, o sea todas las frases que forman con ese conjunto de caracteres, de tamaño N, incluyendo la cadena original. Pero no se debe repetir ninguna y se deben devolver en orden alfabético. Por ejemplo para el texto: CBA

Las cadenas resultantes serán: ABC ACB BAC BCA CAB CBA

Pero si la cadena fuera BAA: AAB ABA BAA*/
	
	public static void main(String[] args) {
		ConstruccionFrases_Backtracking w= new ConstruccionFrases_Backtracking();
		System.out.println(w.permutationFinder("CBA"));
		w.caracteresPermutados("CBA");
		
		
	}
}
class ConstruccionFrases_Backtracking{
	public static Comparable[] quickSort(Comparable[] a) {
		return quickSortr(a,0, a.length-1);
	}
	private  static Comparable[] quickSortr(Comparable[] a, int inicio, int fin) {
		if(fin <= inicio) {
			return a;
		}
		else {
			Comparable pivote = a[fin];
			int i = inicio-1;
			int j = fin;
			Comparable temp;
			while(i<j) {
				while(a[++i].compareTo(pivote)<0);
				while(j > inicio && pivote.compareTo(a[--j])<0);
				if(i<j) {
					temp=a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			temp=a[i];
			a[i]=a[fin];
			a[fin] = temp;
			int partition = i;
			quickSortr(a, inicio, partition-1);
			quickSortr(a, partition+1, fin);
		}
		return a;
	}/*
    
    public void caracteresPermutados(String sentence){
    	String[] set = b(sentence,0).split(",");
    	HashSet<String> set2 = new HashSet<String>();
    	for(String f:set) {
    		set2.add(f);
    	}
    	
    	Comparable[] s=quickSort((Comparable[]) set2.toArray());
    	for(Comparable b:s) {
    		System.out.println(b);
    	}
    	
    
    }
    public String b(String a, int i) {
    	if(a.length() == 1) {
            return  a;
        } else {
        	return a.charAt(i)+ b(a.substring(i, a.length()), i+1)+",";
        
        }
    }
    
    
  
    public static HashSet<String> all_perm(String a) {
        HashSet<String> set = new HashSet<String>();
        if(a.length() == 1) {
            set.add(a);
        } else {
            for(int i=0; i<a.length(); i++) {
                set.addAll(concat(a.charAt(i)+"", all_perm(a.substring(0, i)+a.substring(i+1, a.length()))));
            }
        }
        return set;
    }
    
    public static Set<String> concat(String c, Set<String> lst) {
        HashSet<String> ret_set = new HashSet<String>();
        for(String s: lst) {
            ret_set.add(c+s);
        }
        return ret_set;
    }

   
*/ public static int compareStrings(String word1, String word2)
{
    for(int i = 0; i < Math.min(word1.length(), word2.length()); i++)
    {
        if((int)word1.charAt(i) != (int)word2.charAt(i))//comparing unicode values
            return (int)word1.charAt(i) - (int)word2.charAt(i);
    }
    if(word1.length() != word2.length())//smaller word is occurs at the beginning of the larger word
        return word1.length() - word2.length();
    else
        return 0;
}
public static String[] stringArraySort(String[] words)
{
    for(int i = 0; i < words.length - 1; i++)
    {
        for(int j = i+1; j < words.length; j++)
        {
            if(compareStrings(words[i], words[j]) > 0)//words[i] is greater than words[j]
            {
                String temp = words[i];
                words[i] = words[j];
                words[j] = temp;
            }
        }
    }
    return words;
}
	
	public void caracteresPermutados(String sentence){
	Set<String> set =permutationFinder(sentence);
	System.out.println(set);
	String[] a= new String[set.size()];
	Iterator<String> it = set.iterator();
	int i=0;
	while(it.hasNext()) {
		a[i]=it.next();
		i++;
	}
	String[] b=stringArraySort(a);
	for(String f:b) {
		System.out.println(f);
	}
	
    // Complete el código
}
	 public static Set<String> permutationFinder(String str) {
	        Set<String> perm = new HashSet<String>();
	        if (str == null) {
	            return null;
	        } else if (str.length() == 0) {
	            perm.add("");
	            return perm;
	        }
	        char initial = str.charAt(0); 
	        String rem = str.substring(1);
	        Set<String> words = permutationFinder(rem);
	        for (String strNew : words) {
	            for (int i = 0;i<=strNew.length();i++){
	                perm.add(insertChar(strNew, initial, i));
	            }
	        }
	        return perm;
	    }

	    public static String insertChar(String str, char c, int j) {
	        String begin = str.substring(0, j);
	        String end = str.substring(j);
	        return begin + c + end;
	    }
	    public static void main(String[] args) {
			ConstruccionFrases_Backtracking w= new ConstruccionFrases_Backtracking();
			System.out.println(w.permutationFinder("CBA"));
			w.caracteresPermutados("CBA");
			
			
		}
    // Implemente las funciones que necesite

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line= in.nextLine();
        ConstruccionFrases_Backtracking create=new ConstruccionFrases_Backtracking();
        create.caracteresPermutados(line);
        in.close();
    }*/
}
