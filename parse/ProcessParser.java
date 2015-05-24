/* ProcessParser.java */
/* Generated By:JavaCC: Do not edit this line. ProcessParser.java */
    package parse;

    import java.lang.*;
    import java.io.*;
    import java.util.*;
    import pspdata.*;
    import sqlbox.*;

    public class ProcessParser implements ProcessParserConstants {
        public static Contents parse(String path) throws IOException{
            Contents c = new Contents();
            try{
                ProcessParser pp = new ProcessParser(getBR(path));
                pp.compilation_unit(c);
            }catch(ParseException ex){
                System.out.println(ex);
            }
            return c;
        }
        private static BufferedReader getBR(String path) throws IOException{
            return new BufferedReader(new FileReader(new File(path)));
        }

  final public void compilation_unit(Contents c) throws ParseException {
    condition(c);
    expression(c);
  }

  final public void condition(Contents c) throws ParseException {String str;
    str = assignment(c);
System.out.println(str);
  }

  final public String assignment(Contents c) throws ParseException {String t,t1;
    t = expressionName();
    jj_consume_token(EQ);
    jj_consume_token(WQ);
    t1 = assignmentExp();
    jj_consume_token(WQ);
    jj_consume_token(SM);
c.setCondition(t1);
        {if ("" != null) return t + " = \u005c"" + t1+"\u005c";";}
    throw new Error("Missing return statement in function");
  }

  final public String expressionName() throws ParseException {Token t;
    t = jj_consume_token(IDENTIFIERS);
{if ("" != null) return t.image;}
    throw new Error("Missing return statement in function");
  }

  final public String assignmentExp() throws ParseException {Token t;
    t = jj_consume_token(STR);
{if ("" != null) return t.image;}
    throw new Error("Missing return statement in function");
  }

  final public void expression(Contents c) throws ParseException {String exp="";
    exp = graphExpression(c);
    jj_consume_token(SM);
System.out.println(exp+";");
  }

  final public String graphExpression(Contents c) throws ParseException {String data_exp;
    Token graph_type;
    jj_consume_token(GRAPH);
    jj_consume_token(LC);
    data_exp = dataExpression(c);
    jj_consume_token(COM);
    jj_consume_token(WQ);
    graph_type = graphType();
    jj_consume_token(WQ);
    jj_consume_token(RC);
{if ("" != null) return "Graph.print("+data_exp+","+graph_type.image+")";}
    throw new Error("Missing return statement in function");
  }

  final public String dataExpression(Contents c) throws ParseException {String data_exp = "";
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case DB:{
      data_exp = dbExpression(c);
{if ("" != null) return data_exp;}
      break;
      }
    case IDENTIFIERS:{
      data_exp = processExpression(c);
{if ("" != null) return data_exp;}
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String processExpression(Contents c) throws ParseException {Token name;
    String input;
    name = processName();
c.addProcess(BoxFactory.createBox(name.image));
            System.out.println("Pro_name: "+name);
    jj_consume_token(LC);
    input = input(c);
    jj_consume_token(RC);
System.out.println("input: "+input);
            {if ("" != null) return name.image + "("+input+")";}
    throw new Error("Missing return statement in function");
  }

  final public String input(Contents c) throws ParseException {String exp,temp;
    exp = dataExpression(c);
System.out.println("exp: "+exp);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COM:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      jj_consume_token(COM);
      temp = dataExpression(c);
System.out.println("temp: "+temp);
                exp += temp;
    }
{if ("" != null) return exp;}
    throw new Error("Missing return statement in function");
  }

  final public String dbExpression(Contents c) throws ParseException {String db_input;
    jj_consume_token(DB);
System.out.println("DB:");
    jj_consume_token(LC);
    db_input = dbInput(c);
    jj_consume_token(RC);
{if ("" != null) return "DB("+db_input+")";}
    throw new Error("Missing return statement in function");
  }

  final public String dbInput(Contents c) throws ParseException {Token table_name,x_asix,y_asix,condition;
    jj_consume_token(WQ);
    table_name = tableName();
    jj_consume_token(WQ);
    jj_consume_token(COM);
    jj_consume_token(WQ);
    x_asix = xAsix();
    jj_consume_token(WQ);
    jj_consume_token(COM);
    jj_consume_token(WQ);
    y_asix = yAsix();
    jj_consume_token(WQ);
    jj_consume_token(COM);
    condition = jj_consume_token(IDENTIFIERS);
System.out.println("Table:"+table_name.image);
            System.out.println("X:"+x_asix.image);
            System.out.println("Y:"+y_asix.image);
            System.out.println("condition:"+c.getCondition());
            c.addProcess(BoxFactory.createDBBox(x_asix.image,y_asix.image));
            {if ("" != null) return table_name.image+","+x_asix.image+","+y_asix.image+","+c.getCondition();}
    throw new Error("Missing return statement in function");
  }

  final public Token graphType() throws ParseException {Token t;
    t = jj_consume_token(IDENTIFIERS);
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
  }

  final public Token tableName() throws ParseException {Token t;
    t = jj_consume_token(IDENTIFIERS);
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
  }

  final public Token xAsix() throws ParseException {Token t;
    t = jj_consume_token(IDENTIFIERS);
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
  }

  final public Token yAsix() throws ParseException {Token t;
    t = jj_consume_token(IDENTIFIERS);
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
  }

  final public Token processName() throws ParseException {Token t;
    t = jj_consume_token(IDENTIFIERS);
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public ProcessParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[2];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x18000,0x100,};
   }

  /** Constructor with InputStream. */
  public ProcessParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ProcessParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ProcessParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ProcessParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ProcessParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ProcessParser(ProcessParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ProcessParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[18];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 2; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 18; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

    }
