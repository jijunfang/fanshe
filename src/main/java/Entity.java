import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //如果要被反射发现，必须用runtime 因为反射是一个运营时能力
@Target(ElementType.TYPE)
public @interface Entity {
}
