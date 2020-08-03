import java.io.*;
public class text {
	public static void main(String[] args) {
		if(args.length == 2) new CopyMaker().copy(args[0],args[1]);
		else System.out.println("Please enter file names");
	}
}
class CopyMaker{
	private String sourceName,destName;
	private BufferedWriter dest;
	private BufferedReader source;
	private String line;
	private boolean openFiles() {
		try {
			source = new BufferedReader(new FileReader(sourceName));
		}catch(IOException iox) {
			System.out.println("Problem opening "+sourceName);
			return false;
		}
		try {
			dest = new BufferedWriter(new FileWriter(destName));
		}catch(IOException iox) {
			System.out.println("Problem opening "+destName);
			return false;
		}
		return true;
	}
	private boolean copyFiles() {
		try {
			while((line = source.readLine())!=null) {
				dest.write(line);
				dest.newLine();
			}
		}catch(IOException iox) {
			System.out.println("Problem reading or writing ");
			return false;
		}
		return true;
	}
	private boolean closeFiles() {
		boolean flag = true;
		try {
			source.close();
		}catch(IOException iox) {
			System.out.println("Problem closing "+source);
			flag = false;
		}
		try {
			dest.close();
			flag = false;
		}catch(IOException iox) {
			System.out.println("Pronblem closing "+dest);
		}
		return flag;
	}
	public boolean copy(String sourceName,String destName) {
		this.sourceName = sourceName;
		this.destName = destName;
		return openFiles()&&copyFiles()&&closeFiles();
	}
}
