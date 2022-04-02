package test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotusingLambda {
		private Set<File> files;
		
		private Set<File> tempfilesFileFilterExt;
		private Set<File> tempfilesFileFilterShowHidden;
		private Set<File> tempfilesFileFilterName;
		private Set<File> tempfilesFileFilterRegex;
		
		NotusingLambda() {
			files = new HashSet<>();
			tempfilesFileFilterExt = new HashSet<>();
			tempfilesFileFilterShowHidden = new HashSet<>();
			tempfilesFileFilterName = new HashSet<>();
			tempfilesFileFilterRegex = new HashSet<>();
		}
	//can improve?
		public void setFileFilterExt(String ext) {
			Set<File> s = new HashSet<>();
			if(ext == null) createTempFiles(tempfilesFileFilterExt);
			for(File f : files) {
				if(!f.getPath().toLowerCase().endsWith(ext.toLowerCase())) {
					s.add(f);
				}
			}
			files.removeAll(s);
			tempfilesFileFilterExt.addAll(s);
		}
		
		public void setFileFilterShowHidden(boolean showHidden) {
			if(showHidden) createTempFiles(tempfilesFileFilterShowHidden);
			for(File f : files) {
				if(f.isHidden() && !showHidden) {
					files.remove(f);
					tempfilesFileFilterShowHidden.add(f);
				}
			}
		}
		
		public void setFileFilterName(String name) {
			if(name == null) createTempFiles(tempfilesFileFilterName);
			for(File f : files) {
				if(f.getName().contains(name)) {
					files.remove(f);
					tempfilesFileFilterName.add(f);
				}
			}
		}
		
		public void setFileFilterRegex(String pattern) {
			Pattern p = Pattern.compile(pattern);
			for(File f : files) {
				Matcher m = p.matcher(f.getName());
				if(!m.matches()) {
					files.remove(f);
					tempfilesFileFilterRegex.add(f);
				}
			}
		}
		
		private void createTempFiles(Set<File> tempfiles) {
			files.addAll(tempfiles);
			tempfiles.clear();
			return;
		}
}

