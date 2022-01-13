import java.util.*; 
class ComplexCompare implements Comparator{ 
public int compare(Object objl, Object obj2){ 
Complex z1 = (Complex)objl, z2 = (Complex)obj2; 
double re1 = z1.getRe(), iml = zl.getlm(); 
double re2 = z2.getRe(), im2 = z2.getlm(); 
if (rel != re2) return (int)(re1 - re2); 
else if (im1 != im2) return (int)(im1 — im2); 
else return 0; 
} 
public boolean equals(Object z) { 
return compare(this, z) == 0; 
} 
} 
