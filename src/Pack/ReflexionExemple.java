/*Author Bousri Houssam*/

package Pack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class ReflexionExemple {

	public ReflexionExemple() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveToTxt() {
		
	}
	
	public static void main(String[] args) {
		try {
			File f = new File ("/home/houssam/workspace/projects/Java/Logs/REFLEXION.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f,false));
			Class<RentCar> c = RentCar.class;
			bw.write("Class Name is: "+  c.getName());
			bw.newLine();
			bw.write("Class Name without package is: "+c.getSimpleName());
			bw.newLine();
			bw.write("Package Name is: "+c.getPackage());
			bw.newLine();
			bw.write("Constructors are: "+ Arrays.toString(c.getConstructors()));
			bw.newLine();
			Constructor<RentCar> constructor = c.getConstructor(Integer.TYPE);
			RentCar rent = constructor.newInstance(455);
			Method[] allMethods = c.getMethods();
			bw.write("Methods are: "+ Arrays.toString(c.getMethods()));
			bw.newLine();
			for (int i = 0; i < allMethods.length ; i++) {
				bw.write("Method = "+allMethods[i].getName());
				bw.newLine();
			}
			Method[] declaredMethods = c.getDeclaredMethods();
			bw.write("Methods are: "+ Arrays.toString(c.getDeclaredMethods()));
			for (int i = 0; i < declaredMethods.length ; i++) {
				bw.write("Method = "+declaredMethods[i].getName());
				bw.newLine();
			}
			Method oneMethod = c.getMethod("computeRentalCost", new Class[] {Integer.TYPE});
			bw.write("Methods is: "+ oneMethod);
			bw.newLine();
			oneMethod.invoke(rent, 4);
			bw.write((oneMethod.invoke(rent, 4)).toString());
			bw.newLine();
			Class[] parameterTypes = oneMethod.getParameterTypes();
			bw.write("Parameters type of computeRentalCost() are: "+ Arrays.toString(parameterTypes));
			bw.newLine();
			bw.write("Return type is: "+oneMethod.getReturnType());
			bw.newLine();
			java.lang.reflect.Field[] fields = c.getFields();
			bw.write("Public Fields are: ");
			bw.newLine();
			for (java.lang.reflect.Field oneField : fields) {
				java.lang.reflect.Field field = c.getField(oneField.getName());
				String fieldName = field.getName();
				bw.write("FieldName is: "+fieldName);
				bw.newLine();
				bw.write("Type of field "+fieldName+" is: "+field.getType());
				bw.newLine();
				bw.write("Value of field "+fieldName+" is: "+field.get(rent));
				bw.newLine();
				java.lang.reflect.Field privateField = RentCar.class.getDeclaredField("type");
				bw.write("one private fieldName is: "+ privateField.getName());
				bw.newLine();
				privateField.setAccessible(true);
				bw.write("fieldValue = "+ privateField.get(rent));
				bw.newLine();
			}
			bw.close();
		}catch (NoSuchFieldException n) {
			ExceptionSave s = new ExceptionSave();
			s.save(n);
		}catch (NoSuchMethodException m) {
			ExceptionSave s = new ExceptionSave();
			s.save(m);
		}catch (IllegalArgumentException a) {
			ExceptionSave s = new ExceptionSave();
			s.save(a);
		}catch (IllegalAccessException aa) {
			ExceptionSave s = new ExceptionSave();
			s.save(aa);
		}catch (InstantiationException i) {
			ExceptionSave s = new ExceptionSave();
			s.save(i);
		}catch (InvocationTargetException t) {
			ExceptionSave s = new ExceptionSave();
			s.save(t);
		}catch (IOException i) {
			ExceptionSave s = new ExceptionSave();
			s.save(i);
		} catch (Exception e) {
			// TODO: handle exception
			ExceptionSave s = new ExceptionSave();
			s.save(e);
		} finally {
			System.out.println("Job Done!");
		}
		
	}
}
