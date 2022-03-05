// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/Amod3.gold"
import gold.*;
import gold.structures.*;
import gold.structures.automaton.*;
import gold.structures.bag.*;
import gold.structures.collection.*;
import gold.structures.deque.*;
import gold.structures.disjointset.*;
import gold.structures.graph.*;
import gold.structures.heap.*;
import gold.structures.list.*;
import gold.structures.map.*;
import gold.structures.multimap.*;
import gold.structures.point.*;
import gold.structures.queue.*;
import gold.structures.set.*;
import gold.structures.stack.*;
import gold.structures.tree.*;
import gold.structures.tree.binary.*;
import gold.structures.tree.nary.*;
import gold.structures.tuple.*;
import gold.structures.turingMachine.*;
import gold.swing.*;
import gold.swing.icon.*;
import gold.swing.icon.ajaxload.*;
import gold.swing.icon.famfamfam.*;
import gold.swing.icon.gold.*;
import gold.swing.icon.jlfgr.*;
import gold.swing.icon.wikimedia.*;
import gold.swing.icon.windows.*;
import gold.swing.look.*;
import gold.swing.util.*;
import gold.test.*;
import gold.test.automaton.*;
import gold.test.general.*;
import gold.test.graph.*;
import gold.util.*;
import gold.visualization.*;
import gold.visualization.automaton.*;
import gold.visualization.graph.*;
import gold.visualization.quadtree.*;
import gold.visualization.turingMachine.*;
import gold.visualization.util.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class Amod3 {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=19;
      java.util.Scanner sc=null;
      sc=$invokeConstructor(java.util.Scanner.class,new Object[]{$invokeField(System.class,"in",true,null)});
      $line=20;
      Object coder=$fix(Amod3.createCoder());
      $line=21;
      Object deCoder=$fix(Amod3.createDecoder());
      $line=28;
      Utilities.testCodeDecode($cast(gold.structures.automaton.ITransducer.class,coder),$cast(gold.structures.automaton.ITransducer.class,deCoder));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Amod3.class,"main",$line);
    }
  }
  public static ITransducer createCoder() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=37;
      Object Q=$fix(GCollections.asSet(0,2,1));
      $line=39;
      Object In=$fix(GCollections.asSet('a','b'));
      $line=40;
      Object Out=$fix($opIntvlY('0','2'));
      $line=41;
      Object q_0=$fix(0);
      $line=42;
      Object F=$fix(Q);
      $line=44;
      $result=$invokeConstructor(GDeterministicTransducer.class,new Object[]{Q,In,Out,q_0,F,new GMethod(Amod3.class,"\u03B4"),new GMethod(Amod3.class,"g"),new GMethod(Amod3.class,"h")});
      if (true) break $try;
      $line=45;
      $rethrow(new RuntimeException("The function \"createCoder()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Amod3.class,"createCoder",$line);
    }
    return $cast(ITransducer.class,$result);
  }
  public static Object \u03B4(Object q, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      $result=(($bool($opEqualY(s,'a')))?($opModulY($opAdditY(q,1),3)):(q));
      if (true) break $try;
      $line=48;
      $rethrow(new RuntimeException("The function \"\u03B4(q:Object,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Amod3.class,"\u03B4",$line);
    }
    return $result;
  }
  public static Object g(Object q) {
    int $line=0;
    Object $result=null;
    $try:try {
      $result=q;
      if (true) break $try;
      $line=50;
      $rethrow(new RuntimeException("The function \"g(q:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Amod3.class,"g",$line);
    }
    return $result;
  }
  public static Object h(Object q, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      $result="";
      if (true) break $try;
      $line=52;
      $rethrow(new RuntimeException("The function \"h(q:Object,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Amod3.class,"h",$line);
    }
    return $result;
  }
  public static ITransducer createDecoder() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=59;
      Object Q=$fix(GCollections.asSet(0,2,1,"E","I"));
      $line=61;
      Object \u03A3_=$fix(GCollections.asSet('a','b'));
      $line=62;
      Object \u03A3=$fix(GCollections.asSet('0','1','2'));
      $line=63;
      Object F=$fix($opDiffeY(Q,GCollections.asSet("E")));
      $line=64;
      $result=$invokeConstructor(GDeterministicTransducer.class,new Object[]{Q,\u03A3,\u03A3_,"I",F,new GMethod(Amod3.class,"\u03B41"),new GMethod(Amod3.class,"g1"),new GMethod(Amod3.class,"h1")});
      if (true) break $try;
      $line=65;
      $rethrow(new RuntimeException("The function \"createDecoder()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Amod3.class,"createDecoder",$line);
    }
    return $cast(ITransducer.class,$result);
  }
  public static Object \u03B41(Object q, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=70;
      Object d=$fix($opSubtrY(s,'0'));
      $line=72;
      if (($opEqualY(q,"I")&&$opEqualY(d,0))) {
        $line=72;
        $result=0;
        if (true) break $try;
      }
      else {
        $line=73;
        if (($opMembrY(q,$opIntvlY(0,2))&&$opEqualY(q,d))) {
          $line=73;
          $result=q;
          if (true) break $try;
        }
        else {
          $line=74;
          if (($opMembrY(q,$opIntvlY(0,2))&&$opEqualY(d,$opModulY($opAdditY(q,1),3)))) {
            $line=74;
            $result=d;
            if (true) break $try;
          }
          else {
            $line=75;
            $result="E";
            if (true) break $try;
          }
        }
      }
      $line=78;
      $rethrow(new RuntimeException("The function \"\u03B41(q:Object,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Amod3.class,"\u03B41",$line);
    }
    return $result;
  }
  public static Object g1(Object q) {
    int $line=0;
    Object $result=null;
    $try:try {
      $result="";
      if (true) break $try;
      $line=81;
      $rethrow(new RuntimeException("The function \"g1(q:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Amod3.class,"g1",$line);
    }
    return $result;
  }
  public static Object h1(Object q, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=85;
      Object d=$fix($opSubtrY(s,'0'));
      $line=86;
      if (($opEqualY(q,"I")||$opEqualY(q,"E"))) {
        $line=86;
        $result="";
        if (true) break $try;
      }
      else {
        $line=87;
        if ($opEqualY(q,d)) {
          $line=87;
          $result="b";
          if (true) break $try;
        }
        else {
          $line=88;
          if ($opEqualY($opModulY($opAdditY(q,1),3),d)) {
            $line=88;
            $result="a";
            if (true) break $try;
          }
          else {
            $line=89;
            $result="";
            if (true) break $try;
          }
        }
      }
      $line=91;
      $rethrow(new RuntimeException("The function \"h1(q:Object,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Amod3.class,"h1",$line);
    }
    return $result;
  }
}