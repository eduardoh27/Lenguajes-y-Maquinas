// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/MusicalNotes.gold"
import gold.structures.automaton.*;
import gold.structures.set.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class MusicalNotes {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=6;
      Object Q=$fix(GCollections.asSet("1","2","3","e"));
      $line=7;
      Object \u03A3=$fix(GCollections.asSet('A','B','C','D','E','F','G','b','s'));
      $line=8;
      Object qI=$fix("1");
      $line=9;
      Object F=$fix(GCollections.asSet("3"));
      $line=10;
      Object \u03B4=$fix(new Object[]{new Object[]{"1",'A',"2"},new Object[]{"1",'B',"2"},new Object[]{"1",'C',"2"},new Object[]{"1",'D',"2"},new Object[]{"1",'E',"2"},new Object[]{"1",'F',"2"},new Object[]{"1",'G',"2"},new Object[]{"1",'b',"e"},new Object[]{"1",'s',"e"},new Object[]{"2",'A',"2"},new Object[]{"2",'B',"2"},new Object[]{"2",'C',"2"},new Object[]{"2",'D',"2"},new Object[]{"2",'E',"2"},new Object[]{"2",'F',"2"},new Object[]{"2",'G',"2"},new Object[]{"2",'b',"3"},new Object[]{"2",'s',"3"},new Object[]{"e",'A',"e"},new Object[]{"e",'B',"e"},new Object[]{"e",'C',"e"},new Object[]{"e",'D',"e"},new Object[]{"e",'E',"e"},new Object[]{"e",'F',"e"},new Object[]{"e",'G',"e"},new Object[]{"e",'b',"e"},new Object[]{"e",'s',"e"},new Object[]{"3",'A',"e"},new Object[]{"3",'B',"e"},new Object[]{"3",'C',"e"},new Object[]{"3",'D',"e"},new Object[]{"3",'E',"e"},new Object[]{"3",'F',"e"},new Object[]{"3",'G',"e"},new Object[]{"3",'b',"e"},new Object[]{"3",'s',"e"}});
      $line=50;
      GDeterministicAutomaton A=$cast(GDeterministicAutomaton.class,$fix($invokeConstructor(GDeterministicAutomaton.class,new Object[]{Q,\u03A3,qI,F,\u03B4})));
      $line=51;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,A));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,MusicalNotes.class,"main",$line);
    }
  }
}