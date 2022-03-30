package String;

public class CheckStringsRotationOfEachOther {
	
	static boolean isRotation(String s1, String s2) {
		return (s1.length() == s2.length() && (s1+s1).indexOf(s2) != -1);
	}
	
	public static void main(String[] args) {
		String s1 = "ABCAD";
		String s2 = "AADBC";
		System.out.println("s1:- "+ s1 + "  s2:- "+ s2+ "  are "+ (isRotation(s1,s2) ?" Rotation ": " not Rotation " ) + "of each other");
	}
}
