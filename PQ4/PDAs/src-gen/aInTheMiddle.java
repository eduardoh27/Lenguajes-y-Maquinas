// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/aInTheMiddle.gold"
import gold.structures.automaton.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class aInTheMiddle {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=16;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,aInTheMiddle.createAutomaton()));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,aInTheMiddle.class,"main",$line);
    }
  }
  public static IPushdownAutomaton createAutomaton() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=19;
      Object \u03A3=$fix($opIntvlY('a','b'));
      $line=21;
      Object Q=$fix(GCollections.asSet('I','F'));
      $line=23;
      Object \u0393=$fix(GCollections.asSet('1'));
      $line=24;
      Object q_0=$fix('I');
      $line=25;
      Object F=$fix(GCollections.asSet('F'));
      $line=26;
      Object M=$fix($invokeConstructor(GPushdownAutomaton.class,new Object[]{Q,\u03A3,\u0393,q_0,F}));
      $line=28;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta('I','I',$cast(java.lang.String.class,'a')),new Object[]{"1"});
      $line=29;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta('I','I',$cast(java.lang.String.class,'b')),new Object[]{"1"});
      $line=30;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta('I','F',$cast(java.lang.String.class,'a')),new Object[]{});
      $line=32;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta('F','F',$cast(java.lang.String.class,"a")),new Object[]{"1"});
      $line=33;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta('F','F',$cast(java.lang.String.class,'b')),new Object[]{"1"});
      $line=35;
      $result=M;
      if (true) break $try;
      $line=36;
      $rethrow(new RuntimeException("The function \"createAutomaton()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,aInTheMiddle.class,"createAutomaton",$line);
    }
    return $cast(IPushdownAutomaton.class,$result);
  }
}
