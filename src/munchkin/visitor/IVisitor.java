package munchkin.visitor;


import java.util.Map;

public interface IVisitor {
	public void preCombat(IDoorTraverser t);
	public void duringCombat(IDoorTraverser t);
	public void postCombat(IDoorTraverser t);
	public void addVisit(VisitDoorType visitType, Class<?> clazz, IVisitMethod m);
	public void removeVisit(VisitDoorType visitType, Class<?> clazz);
	public Map<LookupDoorKey, IVisitMethod> getMap();
}
