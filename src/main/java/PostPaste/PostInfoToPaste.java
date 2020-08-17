import com.besaba.revonline.pastebinapi.Pastebin;
import com.besaba.revonline.pastebinapi.impl.factory.PastebinFactory;
import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.paste.PasteBuilder;
import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;
import com.besaba.revonline.pastebinapi.response.Response;

public class PostInfoToPaste {
	public static final String DEV_KEY = "WK4qvKCq4A5RHQv4s3wGVpDblATY9Sb_";

  public static void main(String[] args) {
  	String s = "Hello this is a sample post containing information about BLM and other various info.\nprotest 1\nshop 1\nthing2\nthing3";
  	System.out.println(postToPaste(s));
  }

  public static String postToPaste(String infoToBePosted) {
  	PastebinFactory factory = new PastebinFactory();
  	Pastebin pastebin = factory.createPastebin(DEV_KEY);

  	final PasteBuilder pasteBuilder = factory.createPaste();

  	pasteBuilder.setTitle("projectDSG");
  	pasteBuilder.setRaw(infoToBePosted);
  	pasteBuilder.setMachineFriendlyLanguage("text");
  	pasteBuilder.setVisiblity(PasteVisiblity.Public);
  	pasteBuilder.setExpire(PasteExpire.OneDay);

  	final Paste paste = pasteBuilder.build();

  	final Response<String> postResult = pastebin.post(paste);

  	if (postResult.hasError()) {
  		return postResult.getError();
  	}

  	return postResult.get();
  }
}