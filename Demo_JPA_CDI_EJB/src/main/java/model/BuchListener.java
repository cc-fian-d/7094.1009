package model;

import javax.persistence.PostLoad;

public class BuchListener {

	/**
	 * @PostLoad Executed after an entity has been loaded in the current persistence
	 *           context or an entity has been refreshed.
	 * 
	 * @PrePersist Executed before the entity manager persist operation is actually
	 *             executed or cascaded. If entities are merged, then this is
	 *             invoked after the entity state has been copied. This method is
	 *             synchronous with the persist operation.
	 * 
	 * 
	 * @PostPersist Executed after the entity has been persisted or cascaded.
	 *              Invoked after the database INSERT is executed. Generated key
	 *              values are available in this method.
	 * 
	 * @PreUpdate Executed before the database UPDATE operation.
	 * 
	 * @PostUpdate Executed after the database UPDATE operation.
	 * 
	 * @PreRemove Executed before the entity manager remove operation is actually
	 *            executed or cascaded. This method is synchronous with the remove
	 *            operation.
	 */
	//@PostLoad
	public void buchPostLoad(Buch b) {
		System.out.println(b);
	}
}
