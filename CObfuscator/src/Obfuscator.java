import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Obfuscator {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		String obfuscatedFileName = createNewFile(args[0]);
		String obfuscatedFileName1 = createNewFile(args[0]);
		String obfuscatedFileName2 = createNewFile(args[0]);
		String obfuscatedFileName3 = createNewFile(args[0]);
		
		removeSingleLineComments(args[0] , obfuscatedFileName);
		removeMultiLineComments(obfuscatedFileName , obfuscatedFileName1);
		
		if(Files.deleteIfExists(Paths.get(obfuscatedFileName))) {
			System.out.println("File deleted");
		}else System.out.println("File not found");
		
		removeWhiteSpaces(obfuscatedFileName1, obfuscatedFileName2);
		
		if(Files.deleteIfExists(Paths.get(obfuscatedFileName1))) {
			System.out.println("File deleted");
		}else System.out.println("File not found");
		
		obfuscateFile(obfuscatedFileName2, obfuscatedFileName3);
		
		if(Files.deleteIfExists(Paths.get(obfuscatedFileName2))) {
			System.out.println("File deleted");
		}else System.out.println("File not found");
	}
	
	 // 1. Remove single line comments
	static void removeSingleLineComments(String filename, String obfuscatedFileName) throws IOException {
		BufferedReader reader;
		FileWriter fileWriter = new FileWriter(obfuscatedFileName, true);
	    BufferedWriter writer = new BufferedWriter(fileWriter);
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				if(line.contains("//")) {
					int index = line.indexOf("//");
					line = line.substring(0, index) ;
				} 
				
				writer.write(line);
				writer.newLine();
				// read next line
				line = reader.readLine();
			}
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 2. Remove multi-line comments
	static void removeMultiLineComments(String filename, String obfuscatedFileName) throws NoSuchAlgorithmException, IOException {
		BufferedReader reader;
		
		FileWriter fileWriter = new FileWriter(obfuscatedFileName, true);
	    BufferedWriter writer = new BufferedWriter(fileWriter);

		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				
				if(line.contains("/*") && line.contains("*/")) {
					int index = line.indexOf("/*");
					String newLine = line.substring(0, index) ;
					writer.write(newLine);
					writer.newLine();
					line = reader.readLine();
				}
				
				if(line.contains("/*")) {
					line = reader.readLine();
					while(!line.contains("*/")) {
						line = reader.readLine();
					}
					line = reader.readLine();
				}
				
				writer.write(line);
				writer.newLine();
				line = reader.readLine();
			}
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	// 3. Remove white spaces and new lines \n
	static void removeWhiteSpaces(String filename, String obfuscatedFileName) throws IOException {
		BufferedReader reader;
		
		FileWriter fileWriter = new FileWriter(obfuscatedFileName, true);
	    BufferedWriter writer = new BufferedWriter(fileWriter);

		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				if(line.contains("#")) {
					writer.write(line);
					writer.newLine();
					line = reader.readLine();
				} else {
					String newLine = line.replaceAll("   ", "");
					writer.write(newLine);
					line = reader.readLine();
				}
				
			}
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String createNewFile(String initialFileName) throws IOException, NoSuchAlgorithmException {;
		int index = initialFileName.indexOf(".");
		String obfustactedFileName = initialFileName.substring(0, index) + generateTrulyRandomNo() + ".c";
		
		 FileWriter myWriter = new FileWriter(obfustactedFileName);
		 myWriter.close();
		 return obfustactedFileName;
	}
	
	static int generateTrulyRandomNo() throws NoSuchAlgorithmException {
		return SecureRandom.getInstanceStrong().nextInt();
	}
	
	public static int generateRandom() throws IOException
	{
	    int num = 0;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    for (int i = 0 ; i < Integer.SIZE ; i++)
	    {
	        System.out.println("Flip a fair coin. Enter h for heads, anything else for tails.");

	        if (br.readLine().charAt(0) == 'h')
	        {
	            num += Math.pow(2, i);
	        }
	    }

	    return num;
	}
	
	static void obfuscateFile(String filename, String obfuscatedFileName) throws IOException {
		BufferedReader reader;
		
		FileWriter fileWriter = new FileWriter(obfuscatedFileName, true);
	    BufferedWriter writer = new BufferedWriter(fileWriter);
	    StringBuilder content = new StringBuilder();
	    StringBuilder append = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				if(line.contains("#")) {
					content.append(line+"\n");
					line = reader.readLine();
				}
				String words[] = line.split(" ");
				String newWords[] = words;
				
				String ap = "#define _goto int\n";
				append.append(ap, 0, ap.length());
				ap = "#define r return\n";
				append.append(ap, 0, ap.length());
				ap = "#define __goto float\n";
				append.append(ap, 0, ap.length());
				ap = "#define ___goto char*\n";
				append.append(ap, 0, ap.length());
				ap = "#define _999 0\n";
				append.append(ap, 0, ap.length());
				ap = "#define _888_ 1\n";
				append.append(ap, 0, ap.length());
				ap = "#define _777 2\n";
				append.append(ap, 0, ap.length());
				ap = "#define _99_ 3\n";
				append.append(ap, 0, ap.length());
				ap = "#define _0_0 4\n";
				append.append(ap, 0, ap.length());
				ap = "#define _555 5\n";
				append.append(ap, 0, ap.length());
				ap = "#define __9 6\n";
				append.append(ap, 0, ap.length());
				ap = "#define _090__ 7\n";
				append.append(ap, 0, ap.length());
				ap = "#define ____9_1 8\n";
				append.append(ap, 0, ap.length());
				ap = "#define n9__9 9\n";
				append.append(ap, 0, ap.length());
				ap = "#define ___ main()\n";
				append.append(ap, 0, ap.length());
				ap = "#define _ sum\n";
				append.append(ap, 0, ap.length());
				ap = "#define __________ getchar();\n";
				append.append(ap, 0, ap.length());
				
				for(int i = 0; i < words.length; i++) {
					switch(words[i]) {
					case "int":
						newWords[i] = "_goto";
						break;
					case "float":
						newWords[i] = "__goto";
						break;
					case "char*":
						newWords[i] = "___goto";
						break;
					case "0":
						newWords[i] = "_999";
						break;
					case "1":
						newWords[i] = "_888_";
						break;
					case "2":
						newWords[i] = "_777";
						break;
					case "3":
						newWords[i] = "_99_";
						break;
					case "4":
						newWords[i] = "_0_0";
						break;
					case "5":
						newWords[i] = "_555";
						break;
					case "6":
						newWords[i] = "__9";
						break;
					case "7":
						newWords[i] = "_090__";
						break;
					case "8":
						newWords[i] = "____9_1";
						break;
					case "9":
						newWords[i] = "n9__9";
						break;
					case "return":
						newWords[i] = "r";
						break;
					case "main()":
						newWords[i] = "___";
						break;
					case "sum":
						newWords[i] = "_";
						break;
					case "getchar();":
						newWords[i] = "__________";
						break;
					default: break;
					}
				}
				
				content.append(append,0,append.length());
				String newLine = String.join(" ", newWords);
				content.append(newLine);
				line = reader.readLine();
			}
			
			writer.write(content.toString());
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
