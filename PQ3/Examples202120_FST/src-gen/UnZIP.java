// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/UnZIP.gold"
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
public final class UnZIP {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static Object A=null;
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=25;
      if ($opEqualY($invokeField("length",args),0)) {
        $line=25;
        A=$fix($opIntvlY('a','c'));
      }
      else {
        $line=27;
        gold.structures.set.ISet $v1=$newSet();
        int $v3=$int(0);
        int $v4=$int($invokeMethod("length",((java.lang.String[])args)[$int(0)],new Object[]{}))-1;
        $v2:for (int i=$v3; i<=$v4; i++) {
          $v1.add($invokeMethod("charAt",((java.lang.String[])args)[$int(0)],new Object[]{i}));
        }
        A=$fix($opDiffeY($v1,GCollections.asSet('$')));
      }
      $line=32;
      Object unZip=$fix(UnZIP.createTransducer(A));
      $line=34;
      Utilities.test($cast(gold.structures.automaton.IAutomaton.class,unZip));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,UnZIP.class,"main",$line);
    }
  }
  public static ITransducer createTransducer(Object Alph) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=42;
      A=$fix(Alph);
      $line=43;
      Object Q=$fix($opUnionY($opUnionY(GCollections.asSet("I","F","E"),A),$opCartsY(new Object[]{A,$opIntvlY(2,4)})));
      $line=44;
      Object \u03A3=$fix($opUnionY($opUnionY(A,$opIntvlY('2','5')),GCollections.asSet('$')));
      $line=45;
      Object \u03A3_=$fix($opUnionY(A,GCollections.asSet('$')));
      $line=46;
      Object q_0=$fix("I");
      $line=47;
      Object F=$fix(GCollections.asSet("F"));
      $line=48;
      $result=$invokeConstructor(GDeterministicTransducer.class,new Object[]{Q,\u03A3,\u03A3_,q_0,F,new GMethod(UnZIP.class,"\u03B41"),new GMethod(UnZIP.class,"g"),new GMethod(UnZIP.class,"h1")});
      if (true) break $try;
      $line=49;
      $rethrow(new RuntimeException("The function \"createTransducer(Alph:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,UnZIP.class,"createTransducer",$line);
    }
    return $cast(ITransducer.class,$result);
  }
  public static Object \u03B41(Object q, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=52;
      if ($opMembrY(q,GCollections.asSet("E","F"))) {
        $line=52;
        $result="E";
        if (true) break $try;
      }
      else {
        $line=53;
        if ($opEqualY(s,'$')) {
          $line=53;
          $result="F";
          if (true) break $try;
        }
        else {
          $line=54;
          if (($opEqualY(q,"I")&&$opMembrY(s,$opIntvlY('2','5')))) {
            $line=54;
            $result="E";
            if (true) break $try;
          }
          else {
            $line=55;
            if ($opEqualY(q,"I")) {
              $line=55;
              $result=s;
              if (true) break $try;
            }
            else {
              $line=56;
              if (($opMembrY(q,A)&&$opEqualY(s,'5'))) {
                $line=56;
                $result="I";
                if (true) break $try;
              }
              else {
                $line=57;
                if (($opMembrY(q,A)&&$opMembrY(s,$opIntvlY('2','4')))) {
                  $line=57;
                  $result=GCollections.asList(q,$opSubtrY(s,'0'));
                  if (true) break $try;
                }
                else {
                  $line=58;
                  if (($opMembrY(q,A)&&$opEqualY(s,q))) {
                    $line=58;
                    $result="E";
                    if (true) break $try;
                  }
                  else {
                    $line=59;
                    if (($opMembrY(q,A)&&$opMembrY(s,A))) {
                      $line=59;
                      $result=s;
                      if (true) break $try;
                    }
                    else {
                      $line=60;
                      $result="E";
                      if (true) break $try;
                    }
                  }
                }
              }
            }
          }
        }
      }
      $line=62;
      $rethrow(new RuntimeException("The function \"\u03B41(q:Object,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,UnZIP.class,"\u03B41",$line);
    }
    return $result;
  }
  public static Object \u03B41(java.lang.Iterable $v5, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      java.util.Iterator $v6=GCollections.unmodifiableCollection($v5).iterator();
      Object q=$v6.next();
      Object x=$v6.next();
      $line=65;
      if ($opEqualY(s,'$')) {
        $line=65;
        $result="F";
        if (true) break $try;
      }
      else {
        $line=66;
        if ($opMembrY(s,$opIntvlY('2','5'))) {
          $line=66;
          $result="E";
          if (true) break $try;
        }
        else {
          $line=67;
          if ($opEqualY(s,q)) {
            $line=67;
            $result="E";
            if (true) break $try;
          }
          else {
            $line=68;
            $result=s;
            if (true) break $try;
          }
        }
      }
      $line=70;
      $rethrow(new RuntimeException("The function \"\u03B41(\u27E8q,x\u27E9:java.lang.Iterable,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,UnZIP.class,"\u03B41",$line);
    }
    return $result;
  }
  public static Object h1(Object q, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=75;
      if (($opEqualY(q,"F")||$opEqualY(q,"E"))) {
        $line=75;
        $result="";
        if (true) break $try;
      }
      else {
        $line=76;
        if (($opEqualY(s,'$')&&$opMembrY(q,A))) {
          $line=76;
          $result=$opAdditY(q,"$");
          if (true) break $try;
        }
        else {
          $line=77;
          if ($opEqualY(s,'$')) {
            $line=77;
            $result="$";
            if (true) break $try;
          }
          else {
            $line=78;
            if ($opEqualY(q,"I")) {
              $line=78;
              $result="";
              if (true) break $try;
            }
            else {
              $line=79;
              if (($opMembrY(s,$opIntvlY('2','5'))&&$opMembrY(q,A))) {
                $line=79;
                $result=UnZIP.starN(q,$opSubtrY(s,'0'));
                if (true) break $try;
              }
              else {
                $line=80;
                if (($opMembrY(q,A)&&!$opEqualY(s,q))) {
                  $line=80;
                  $result=q;
                  if (true) break $try;
                }
                else {
                  $line=81;
                  $result="";
                  if (true) break $try;
                }
              }
            }
          }
        }
      }
      $line=83;
      $rethrow(new RuntimeException("The function \"h1(q:Object,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,UnZIP.class,"h1",$line);
    }
    return $result;
  }
  public static Object h1(java.lang.Iterable $v7, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      java.util.Iterator $v8=GCollections.unmodifiableCollection($v7).iterator();
      Object last=$v8.next();
      Object count=$v8.next();
      $line=86;
      if ($opEqualY(s,'$')) {
        $line=86;
        $result="$";
        if (true) break $try;
      }
      else {
        $line=87;
        $result="";
        if (true) break $try;
      }
      $line=89;
      $rethrow(new RuntimeException("The function \"h1(\u27E8last,count\u27E9:java.lang.Iterable,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,UnZIP.class,"h1",$line);
    }
    return $result;
  }
  public static Object g(Object q) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=91;
      $result="";
      if (true) break $try;
      $line=92;
      $rethrow(new RuntimeException("The function \"g(q:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,UnZIP.class,"g",$line);
    }
    return $result;
  }
  public static Object starN(Object c, Object n) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=95;
      if ($opEqualY(n,0)) {
        $line=95;
        $result="";
        if (true) break $try;
      }
      else {
        $line=96;
        $result=$opAdditY($invokeMethod(String.class,"valueOf",true,null,new Object[]{c}),UnZIP.starN(c,$opSubtrY(n,1)));
        if (true) break $try;
      }
      $line=98;
      $rethrow(new RuntimeException("The function \"starN(c:Object,n:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,UnZIP.class,"starN",$line);
    }
    return $result;
  }
}