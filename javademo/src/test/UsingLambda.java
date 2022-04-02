package test;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UsingLambda {
	private Set<File> files;
	private Map<String, Set<File>> tempfiles;

	UsingLambda() {
		files = new HashSet<>();
		tempfiles = new HashMap<>();
	}
	
	public void setFileFilterShowHidden(boolean showHidden) {
		boolean filtering = showHidden;
		setFileFilter(e -> {if(e.isHidden()) return false; return true;},
				filtering, "Ext");
	}
	public void setFileFilterExt(String ext) {
		boolean filtering = ext == null ? false : true;
		setFileFilter(e -> {if(e.getPath().toLowerCase().endsWith(ext.toLowerCase())) return false; return true;},
				filtering, "Ext");
	}
	
	public void setFileFilterName(String name) {
		boolean filtering = name == null ? false : true;
		setFileFilter(e -> {if(e.getName().contains(name))return false; return true;},
				filtering, "Name");
	}
	
	public void setFileFilterRegex(String pattern) {
		boolean filtering = pattern == null ? false : true;
		Pattern p = Pattern.compile(pattern);
		setFileFilter(e -> {
			Matcher m = p.matcher(e.getName());
			if(m.matches()) return false;
			return true;
		},
				filtering, "Ext");
	}
	
	private void setFileFilter(filterCondition i, boolean filtering, String filterName) {
		if(filtering) {
			Set<File> temp = new HashSet<>();
			for(File f : files) {
				if(i.check(f)) {
					temp.add(f);
				}
			}
			tempfiles.put(filterName, temp);
			files.removeAll(temp);
			return;
		} 
		files.addAll(tempfiles.get(filterName));
		tempfiles.put(filterName, null);
	}
	private interface filterCondition {
		boolean check(File f);
	}
}
