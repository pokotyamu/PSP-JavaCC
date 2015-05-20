/* ProcessParser.java */
/* Generated By:JavaCC: Do not edit this line. ProcessParser.java */
    import java.lang.*;
    import java.io.*;
    import java.util.*;

    public class ProcessParser implements ProcessParserConstants {
        public static void print(String path) throws IOException{
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                try{
                    System.out.println("hoge "+line);
                    ProcessParser pp = new ProcessParser(new ByteArrayInputStream(line.getBytes()));
                    pp.compilation_unit();
                }catch(ParseException ex){
                    System.out.println(ex);
                }
            }
        }

  final public void compilation_unit() throws ParseException {
    condition();
    expression();
  }

  final public void condition() throws ParseException {String str;
    str = assignment();
System.out.println(str);
  }

  final public String assignment() throws ParseException {String t,t1;
    t = expressionName();
    jj_consume_token(EQ);
    jj_consume_token(WQ);
    t1 = assignmentExp();
    jj_consume_token(WQ);
    jj_consume_token(SM);
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

  final public void expression() throws ParseException {String exp="";
    exp = graphExpression();
    jj_consume_token(SM);
System.out.println(exp+";");
  }

  final public String graphExpression() throws ParseException {String data_exp,graph_type="";
    jj_consume_token(GRAPH);
    jj_consume_token(LC);
    data_exp = dataExpression();
    jj_consume_token(COM);
    jj_consume_token(GRAPH_TYPE);
    jj_consume_token(RC);
    jj_consume_token(SM);
{if ("" != null) return "Graph.print("+data_exp+","+graph_type+")";}
    throw new Error("Missing return statement in function");
  }

  final public String dataExpression() throws ParseException {String data_exp = "";
    data_exp = dbExpression();
{if ("" != null) return data_exp;}
    throw new Error("Missing return statement in function");
  }

  final public String processExpression() throws ParseException {Token name;
    String input;
    name = jj_consume_token(PROCESS_NAME);
    jj_consume_token(LC);
    input = input();
    jj_consume_token(RC);
{if ("" != null) return name.image + "("+input+")";}
    throw new Error("Missing return statement in function");
  }

  final public String input() throws ParseException {String exp1="",exp2="";
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case DB:{
      exp1 = dataExpression();
{if ("" != null) return exp1;}
      break;
      }
    case COM:{
      jj_consume_token(COM);
      exp2 = dataExpression();
{if ("" != null) return exp1 + ","+exp2;}
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String dbExpression() throws ParseException {String db_input;
    jj_consume_token(DB);
    jj_consume_token(LC);
    db_input = dbInput();
    jj_consume_token(RC);
{if ("" != null) return "DB("+db_input+")";}
    throw new Error("Missing return statement in function");
  }

  final public String dbInput() throws ParseException {Token table_name,x_asix,y_asix,condition;
    table_name = jj_consume_token(TABLE_NAME);
    jj_consume_token(COM);
    x_asix = jj_consume_token(X_ASIX);
    jj_consume_token(COM);
    y_asix = jj_consume_token(Y_ASIX);
    jj_consume_token(COM);
    condition = jj_consume_token(STR);
{if ("" != null) return table_name.image+","+x_asix.image+","+y_asix.image+","+condition.image;}
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
  final private int[] jj_la1 = new int[1];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x8100,};
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
    for (int i = 0; i < 1; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 1; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ProcessParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ProcessParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 1; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 1; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ProcessParser(ProcessParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 1; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ProcessParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 1; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[23];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 1; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 23; i++) {
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
