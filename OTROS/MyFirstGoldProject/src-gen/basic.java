// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/basic.gold"
import gold.structures.automaton.*;
import gold.structures.set.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class basic {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=7;
      Object Q=$fix(GCollections.asSet('A','0'));
      $line=8;
      Object \u03A3=$fix(GCollections.asSet('0','1'));
      $line=9;
      Object q=$fix('A');
      $line=10;
      Object F=$fix('B');
      $line=11;
      Object \u03B4=$fix(new Object[]{new Object[]{}});
      $line=12;
      GDeterministicAutomaton A=$cast(GDeterministicAutomaton.class,$fix($invokeConstructor(GDeterministicAutomaton.class,new Object[]{Q,\u03A3,q,F,\u03B4})));
      $line=13;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,A));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,basic.class,"main",$line);
    }
  }
}
