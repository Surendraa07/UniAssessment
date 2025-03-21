package Interfaces;

import myLibs.RegularUserModules;
import myLibs.UserDetailsModules;
import myLibs.UserModules;

public interface InfUserCRUD {
	public boolean Insert(UserModules userModule);
	public boolean Insert(UserDetailsModules userDetailsModules);
	public boolean Insert(RegularUserModules regularUserModules);
}