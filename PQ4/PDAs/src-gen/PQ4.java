// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/PQ4.gold"
import gold.structures.automaton.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class PQ4 {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=5;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,PQ4.createAutomaton()));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,PQ4.class,"main",$line);
    }
  }
  public static IPushdownAutomaton createAutomaton() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=10;
      Object A=$fix(GCollections.asSet("2","5","3"));
      $line=11;
      Object Q=$fix($opUnionY($opUnionY(GCollections.asSet("I","x","\u00F7","2","2=","2x0","2x1","2x1d","r1","F"),GCollections.asSet("3","3=","3x0","3x1","3x2","3x1d","3x2d","r2")),GCollections.asSet("5","5=","5x0","5x1","5x2","5x3","5x4","5x1d","5x2d","5x3d","5x4d","r3","r4")));
      $line=13;
      System.out.println($message(new Object[]{$opMultpY('2',4)}));
      $line=14;
      Object \u03A3=$fix(GCollections.asSet('2','5','3','\u00D7','x','q','r','=','+','\u00F7'));
      $line=15;
      Object \u0393=$fix(GCollections.asSet('x','$','r'));
      $line=17;
      Object q_0=$fix("I");
      $line=18;
      Object F=$fix(GCollections.asSet("F"));
      $line=20;
      Object M=$fix($invokeConstructor(GPushdownAutomaton.class,new Object[]{Q,\u03A3,\u0393,q_0,F}));
      $line=22;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","x",$cast(java.lang.String.class,"")),new Object[]{"$"});
      $line=23;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("x","x",$cast(java.lang.String.class,"x")),new Object[]{"x"});
      $line=24;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta("x","\u00F7",$cast(java.lang.String.class,'\u00F7')),new Object[]{});
      $line=26;
      for (Object $v1:GCollections.unmodifiableCollection(A)) {
        Object t=$v1;
        $line=27;
        Object T=$fix(Integer.parseInt($cast(java.lang.String.class,t)));
        $line=28;
        $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta("\u00F7",t,$cast(java.lang.String.class,t)),new Object[]{});
        $line=29;
        $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(t,$opAdditY(t,"="),$cast(java.lang.String.class,'=')),new Object[]{});
        $line=31;
        if ($bool($opEqualY(t,"2"))) {
          $line=32;
          $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta($opAdditY(t,"="),$opAdditY(t,"="),$cast(java.lang.String.class,'q')),new Object[]{"xx"});
        }
        else {
          $line=34;
          if ($bool($opEqualY(t,"3"))) {
            $line=35;
            $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta($opAdditY(t,"="),$opAdditY(t,"="),$cast(java.lang.String.class,'q')),new Object[]{"xxx"});
          }
          else {
            $line=37;
            $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta($opAdditY(t,"="),$opAdditY(t,"="),$cast(java.lang.String.class,'q')),new Object[]{"xxxxx"});
          }
        }
        $line=41;
        $invokeMethod("skip",((gold.structures.automaton.GPushdownAutomaton)M).delta($opAdditY(t,"="),$opAdditY(t,"x0"),$cast(java.lang.String.class,'\u00D7')),new Object[]{"$"});
        $line=42;
        $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta($opAdditY(t,"x0"),"F",$cast(java.lang.String.class,t)),new Object[]{"$"});
        $line=45;
        $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta($opAdditY(t,"="),$opAdditY(t,"x1"),$cast(java.lang.String.class,'\u00D7')),new Object[]{"x"});
        $line=46;
        $invokeMethod("skip",((gold.structures.automaton.GPushdownAutomaton)M).delta($opAdditY(t,"x1"),$opAdditY(t,"x1d"),$cast(java.lang.String.class,t)),new Object[]{"$"});
        $line=47;
        $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta($opAdditY(t,"x1d"),"r1",$cast(java.lang.String.class,'+')),new Object[]{});
        $line=48;
        $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("r1","F",$cast(java.lang.String.class,'r')),new Object[]{"$"});
        $line=50;
        if (($bool($opEqualY(t,"3"))||$bool($opEqualY(t,"5")))) {
          $line=51;
          $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta($opAdditY(t,"="),$opAdditY(t,"x2"),$cast(java.lang.String.class,'\u00D7')),new Object[]{"xx"});
          $line=52;
          $invokeMethod("skip",((gold.structures.automaton.GPushdownAutomaton)M).delta($opAdditY(t,"x2"),$opAdditY(t,"x2d"),$cast(java.lang.String.class,t)),new Object[]{"$"});
          $line=53;
          $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta($opAdditY(t,"x2d"),"r2",$cast(java.lang.String.class,'+')),new Object[]{});
          $line=54;
          $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("r2","r2",$cast(java.lang.String.class,'r')),new Object[]{"r"});
          $line=55;
          $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("r2","F",$cast(java.lang.String.class,'r')),new Object[]{"$r"});
        }
        $line=58;
        if ($bool($opEqualY(t,"5"))) {
          $line=59;
          $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("5=","5x3",$cast(java.lang.String.class,'\u00D7')),new Object[]{"xxx"});
          $line=60;
          $invokeMethod("skip",((gold.structures.automaton.GPushdownAutomaton)M).delta("5x3","5x3d",$cast(java.lang.String.class,'5')),new Object[]{"$"});
          $line=61;
          $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta("5x3d","r3",$cast(java.lang.String.class,'+')),new Object[]{});
          $line=62;
          $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("r3","r3",$cast(java.lang.String.class,'r')),new Object[]{"r"});
          $line=63;
          $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("r3","F",$cast(java.lang.String.class,'r')),new Object[]{"$rr"});
          $line=66;
          $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("5=","5x4",$cast(java.lang.String.class,'\u00D7')),new Object[]{"xxxx"});
          $line=67;
          $invokeMethod("skip",((gold.structures.automaton.GPushdownAutomaton)M).delta("5x4","5x4d",$cast(java.lang.String.class,'5')),new Object[]{"$"});
          $line=68;
          $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta("5x4d","r4",$cast(java.lang.String.class,'+')),new Object[]{});
          $line=69;
          $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("r4","r4",$cast(java.lang.String.class,'r')),new Object[]{"r"});
          $line=70;
          $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("r4","F",$cast(java.lang.String.class,'r')),new Object[]{"$rrr"});
        }
      }
      $line=76;
      $result=M;
      if (true) break $try;
      $line=77;
      $rethrow(new RuntimeException("The function \"createAutomaton()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,PQ4.class,"createAutomaton",$line);
    }
    return $cast(IPushdownAutomaton.class,$result);
  }
}
