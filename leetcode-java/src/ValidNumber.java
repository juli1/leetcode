
public class ValidNumber {
	 public boolean isNumber(String s) {
	        int pos = 0;
	        int n_numbers = 0;
	        while (pos < s.length() && s.charAt(pos) == ' ')
	        {
	            pos++;
	        }

	        while (pos < s.length() && Character.isDigit(s.charAt(pos)))
	        {
	            pos++;
	            n_numbers++;
	        }
	 
	        if (n_numbers == 0 && (pos == s.length()))
	        {
	            return false;

	        }

	        if (n_numbers >0 && (pos == s.length()))
	        {
	            return true;

	        }
   
	        if (s.charAt(pos) == '.' || s.charAt(pos) == 'e')
	        {
	            if (s.charAt(pos) == 'e' && n_numbers == 0)
	            {
	                return false;
	            }

	            if (s.charAt(pos) != '.')
	            {
	                n_numbers = 0;
	            }

	            pos++;

	            while (pos < s.length() && Character.isDigit(s.charAt(pos)))
	            {
	                pos++;
	                n_numbers++;
	            }

	            if (n_numbers == 0)
	            {
	                return false;
	            }
	        }

	        while (pos < s.length() && s.charAt(pos) == ' ')
	        {
	            pos++;
	        }

	        return (pos == s.length() && n_numbers > 0);

	    }

	 public static void main(String[] args) {
		 ValidNumber v = new ValidNumber();
		 System.out.println(v.isNumber("1.0"));
		 System.out.println(v.isNumber("blabla"));
		 System.out.println(v.isNumber("1e4"));
	}

}
