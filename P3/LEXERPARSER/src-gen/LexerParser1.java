// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/LexerParser1.gold"
import gold.structures.automaton.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class LexerParser1 {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=25;
      Object Lexer=$fix(LexerParser1.createTransducer());
      $line=26;
      Object Parser2=$fix(LexerParser1.createAutomaton2());
      $line=27;
      Object Parser=$fix(LexerParser1.createAutomaton());
      $line=28;
      Object stdin=$fix($invokeConstructor(java.util.Scanner.class,new Object[]{$invokeField(System.class,"in",true,null)}));
      $line=29;
      System.out.println($message(new Object[]{"Do you want to use the parser that implements the grammar directly (1 for YES)"}));
      $line=30;
      String mode=null;
      mode=$defaultValue(String.class);
      $line=31;
      mode=$cast(String.class,$fix(((java.util.Scanner)stdin).nextLine()));
      $line=37;
      if ($opEqualY(((java.lang.String)mode).charAt($int(0)),'1')) {
        $line=40;
        LexerParser1.testParser($cast(gold.structures.automaton.ITransducer.class,Lexer),$cast(gold.structures.automaton.IPushdownAutomaton.class,Parser));
      }
      else {
        $line=46;
        LexerParser1.testParser($cast(gold.structures.automaton.ITransducer.class,Lexer),$cast(gold.structures.automaton.IPushdownAutomaton.class,Parser2));
      }
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser1.class,"main",$line);
    }
  }
  public static Object testParser(ITransducer M, IPushdownAutomaton P) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=56;
      java.util.Scanner sc=null;
      sc=$invokeConstructor(java.util.Scanner.class,new Object[]{$invokeField(System.class,"in",true,null)});
      $line=60;
      System.out.println($message(new Object[]{"----------------------------"}));
      $line=61;
      System.out.println($message(new Object[]{"Enter one or more lines. End with a single line with $"}));
      $line=62;
      System.out.println($message(new Object[]{"If you want to stop testing, enter EXIT"}));
      $line=63;
      Object string=$fix(((java.util.Scanner)sc).nextLine());
      $line=67;
      while (true) {
        if (!(!$opEqualY(string,"EXIT"))) break;
        $line=70;
        Object input=$fix("");
        $line=74;
        while (true) {
          if (!(!$opEqualY(string,"$"))) break;
          $line=75;
          input=$fix($opAdditY($opAdditY(input,string)," "));
          $line=76;
          string=$fix(((java.util.Scanner)sc).nextLine());
        }
        $line=79;
        Object result=$fix(((gold.structures.automaton.ITransducer)M).acceptsString($cast(java.lang.String.class,input)));
        $line=80;
        Object tokenStream=$fix(((gold.structures.automaton.ITransducer)M).getOutputString());
        $line=82;
        System.out.println($message(new Object[]{$opAdditY($opAdditY("The lexer did ",(($bool(result))?(""):("not ")))," accept the string.")}));
        $line=83;
        if ($bool(result)) {
          $line=85;
          System.out.println($message(new Object[]{$opAdditY("Token Stream: ",tokenStream)}));
          $line=86;
          result=$fix(((gold.structures.automaton.IPushdownAutomaton)P).acceptsString($cast(java.lang.String.class,tokenStream)));
          $line=87;
          System.out.println($message(new Object[]{$opAdditY("Parser result: ",(($bool(result))?("accepted "):("rejected ")))}));
        }
        $line=93;
        System.out.println($message(new Object[]{"----------------------------"}));
        $line=95;
        System.out.println($message(new Object[]{"Enter one or more lines. End with a single line with $"}));
        $line=96;
        System.out.println($message(new Object[]{"If you want to stop testing, enter EXIT"}));
        $line=97;
        string=$fix(((java.util.Scanner)sc).nextLine());
      }
      $line=100;
      System.out.println($message(new Object[]{"Good bye"}));
      $line=101;
      System.out.println($message(new Object[]{""}));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser1.class,"testParser",$line);
    }
    return $result;
  }
  public static IPushdownAutomaton createAutomaton() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=116;
      Object Terms=$fix(GCollections.asSet('(',')','+','*','v','n'));
      $line=117;
      Object NonTerms=$fix(GCollections.asSet('E','L'));
      $line=118;
      Object Q=$fix(GCollections.asSet("I","q","F"));
      $line=119;
      Object \u03A3=$fix(Terms);
      $line=120;
      Object \u0393=$fix($opUnionY($opUnionY(Terms,NonTerms),GCollections.asSet('$')));
      $line=121;
      Object q_0=$fix("I");
      $line=122;
      Object F=$fix(GCollections.asSet("F"));
      $line=123;
      Object M=$fix($invokeConstructor(GPushdownAutomaton.class,new Object[]{Q,\u03A3,\u0393,q_0,F}));
      $line=125;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","q",$cast(java.lang.String.class,"")),new Object[]{"$E"});
      $line=126;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","F",$cast(java.lang.String.class,"")),new Object[]{"$"});
      $line=128;
      for (Object $v1:GCollections.unmodifiableCollection(GCollections.asSet('(',')','+','*','v','n'))) {
        Object x=$v1;
        $line=129;
        $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,$opAdditY("",x))),new Object[]{$opAdditY("",x)});
      }
      $line=131;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"E","v"});
      $line=132;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"E","n"});
      $line=133;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"E",")L+("});
      $line=134;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"E",")L*("});
      $line=135;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"L","E"});
      $line=136;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"L","EL"});
      $line=137;
      $result=M;
      if (true) break $try;
      $line=138;
      $rethrow(new RuntimeException("The function \"createAutomaton()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser1.class,"createAutomaton",$line);
    }
    return $cast(IPushdownAutomaton.class,$result);
  }
  public static IPushdownAutomaton createAutomaton2() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=153;
      Object Terms=$fix(GCollections.asSet('(',')','+','*','v','n'));
      $line=154;
      Object NonTerms=$fix(GCollections.asSet('E','L'));
      $line=155;
      Object Q=$fix(GCollections.asSet("I","F"));
      $line=156;
      Object \u03A3=$fix(GCollections.asSet('(',')','+','*','v','n'));
      $line=157;
      Object \u0393=$fix(GCollections.asSet('1'));
      $line=158;
      Object q_0=$fix("I");
      $line=159;
      Object F=$fix(GCollections.asSet("F"));
      $line=160;
      Object M=$fix($invokeConstructor(GPushdownAutomaton.class,new Object[]{Q,\u03A3,\u0393,q_0,F}));
      $line=162;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","I",$cast(java.lang.String.class,"(+")),new Object[]{"1"});
      $line=163;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","I",$cast(java.lang.String.class,"(*")),new Object[]{"1"});
      $line=164;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","F",$cast(java.lang.String.class,"v")),new Object[]{});
      $line=165;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","F",$cast(java.lang.String.class,"n")),new Object[]{});
      $line=166;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("F","F",$cast(java.lang.String.class,")")),new Object[]{"1"});
      $line=167;
      $invokeMethod("skip",((gold.structures.automaton.GPushdownAutomaton)M).delta("F","I",$cast(java.lang.String.class,"")),new Object[]{"1"});
      $line=170;
      $result=M;
      if (true) break $try;
      $line=171;
      $rethrow(new RuntimeException("The function \"createAutomaton2()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser1.class,"createAutomaton2",$line);
    }
    return $cast(IPushdownAutomaton.class,$result);
  }
  public static ITransducer createTransducer() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=179;
      Object Q=$fix(GCollections.asSet("I","Id","p","pl","plu","plus","t","ti","tim","time","times","Num","Err"));
      $line=181;
      Object \u03A3=$fix($opUnionY($opUnionY($opIntvlY('0','9'),$opIntvlY('a','z')),GCollections.asSet('(',')',' ')));
      $line=182;
      Object Out=$fix(GCollections.asSet('(',')','+','*','v','n'));
      $line=183;
      Object q_0=$fix("I");
      $line=184;
      Object F=$fix(GCollections.asSet("I"));
      $line=185;
      $result=$invokeConstructor(GDeterministicTransducer.class,new Object[]{Q,\u03A3,Out,q_0,F,new GMethod(LexerParser1.class,"\u03B4"),new GMethod(LexerParser1.class,"g"),new GMethod(LexerParser1.class,"h")});
      if (true) break $try;
      $line=186;
      $rethrow(new RuntimeException("The function \"createTransducer()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser1.class,"createTransducer",$line);
    }
    return $cast(ITransducer.class,$result);
  }
  public static Object \u03B4(Object q, Object \u03C3) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=189;
      if ($bool($opEqualY(q,"Err"))) {
        $line=189;
        $result="Err";
        if (true) break $try;
      }
      else {
        $line=190;
        if ($opMembrY(\u03C3,GCollections.asSet('(',')',' '))) {
          $line=190;
          $result="I";
          if (true) break $try;
        }
        else {
          $line=191;
          if (($opEqualY(q,"I")&&$opEqualY(\u03C3,'p'))) {
            $line=191;
            $result="p";
            if (true) break $try;
          }
          else {
            $line=192;
            if (($opEqualY(q,"I")&&$opEqualY(\u03C3,'t'))) {
              $line=192;
              $result="t";
              if (true) break $try;
            }
            else {
              $line=193;
              if (($opEqualY(q,"I")&&$opMembrY(\u03C3,$opIntvlY('0','9')))) {
                $line=193;
                $result="Num";
                if (true) break $try;
              }
              else {
                $line=194;
                if (($opEqualY(q,"Num")&&$opMembrY(\u03C3,$opIntvlY('0','9')))) {
                  $line=194;
                  $result="Num";
                  if (true) break $try;
                }
                else {
                  $line=195;
                  if (($opEqualY(q,"Num")&&$opMembrY(\u03C3,$opIntvlY('a','z')))) {
                    $line=195;
                    $result="Err";
                    if (true) break $try;
                  }
                  else {
                    $line=196;
                    if (($opEqualY(q,"p")&&$opEqualY(\u03C3,'l'))) {
                      $line=196;
                      $result="pl";
                      if (true) break $try;
                    }
                    else {
                      $line=197;
                      if (($opEqualY(q,"pl")&&$opEqualY(\u03C3,'u'))) {
                        $line=197;
                        $result="plu";
                        if (true) break $try;
                      }
                      else {
                        $line=198;
                        if (($opEqualY(q,"plu")&&$opEqualY(\u03C3,'s'))) {
                          $line=198;
                          $result="plus";
                          if (true) break $try;
                        }
                        else {
                          $line=199;
                          if (($opEqualY(q,"t")&&$opEqualY(\u03C3,'i'))) {
                            $line=199;
                            $result="ti";
                            if (true) break $try;
                          }
                          else {
                            $line=200;
                            if (($opEqualY(q,"ti")&&$opEqualY(\u03C3,'m'))) {
                              $line=200;
                              $result="tim";
                              if (true) break $try;
                            }
                            else {
                              $line=201;
                              if (($opEqualY(q,"tim")&&$opEqualY(\u03C3,'e'))) {
                                $line=201;
                                $result="time";
                                if (true) break $try;
                              }
                              else {
                                $line=202;
                                if (($opEqualY(q,"time")&&$opEqualY(\u03C3,'s'))) {
                                  $line=202;
                                  $result="times";
                                  if (true) break $try;
                                }
                                else {
                                  $line=203;
                                  $result="Id";
                                  if (true) break $try;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      $line=205;
      $rethrow(new RuntimeException("The function \"\u03B4(q:Object,\u03C3:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser1.class,"\u03B4",$line);
    }
    return $result;
  }
  public static Object g(Object q) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=210;
      $result="";
      if (true) break $try;
      $line=211;
      $rethrow(new RuntimeException("The function \"g(q:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser1.class,"g",$line);
    }
    return $result;
  }
  public static Object h(Object q, Object \u03C3) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=214;
      String s=null;
      s=$defaultValue(String.class);
      $line=215;
      s=$cast(String.class,$fix(""));
      $line=217;
      if ((!$opMembrY(q,GCollections.asSet("Err"))&&$opMembrY(\u03C3,GCollections.asSet('(',')',' ')))) {
        $line=219;
        if (!$opMembrY(\u03C3,GCollections.asSet(' '))) {
          $line=219;
          s=$cast(String.class,$fix($invokeMethod(String.class,"valueOf",true,null,new Object[]{\u03C3})));
        }
        $line=221;
        if ($opEqualY(q,"I")) {
          $line=221;
          $result=s;
          if (true) break $try;
        }
        else {
          $line=222;
          if ($opEqualY(q,"plus")) {
            $line=222;
            $result=$opAdditY("+",s);
            if (true) break $try;
          }
          else {
            $line=223;
            if ($opEqualY(q,"times")) {
              $line=223;
              $result=$opAdditY("*",s);
              if (true) break $try;
            }
            else {
              $line=224;
              if ($opEqualY(q,"Num")) {
                $line=224;
                $result=$opAdditY("n",s);
                if (true) break $try;
              }
              else {
                $line=225;
                $result=$opAdditY("v",s);
                if (true) break $try;
              }
            }
          }
        }
      }
      else {
        $line=227;
        $result="";
        if (true) break $try;
      }
      $line=230;
      $rethrow(new RuntimeException("The function \"h(q:Object,\u03C3:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser1.class,"h",$line);
    }
    return $result;
  }
}