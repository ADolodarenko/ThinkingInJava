package chapter10.innerinheritance;

public class SonOuterClass
{
	public class SonInnerClass extends OuterClass.InnerClass
	{
		public SonInnerClass(OuterClass outer, int i, String s)
		{
			outer.super(i, s);
		}
	}
}
