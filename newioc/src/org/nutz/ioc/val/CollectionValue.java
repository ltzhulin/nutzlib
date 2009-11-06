package org.nutz.ioc.val;

import java.util.ArrayList;
import java.util.Collection;

import org.nutz.ioc.IocMaking;
import org.nutz.ioc.ValueProxy;
import org.nutz.ioc.loader.Loaders;
import org.nutz.lang.Lang;

public class CollectionValue implements ValueProxy {

	private Class<? extends Collection<Object>> type;

	private ValueProxy[] values;

	@SuppressWarnings("unchecked")
	public CollectionValue(	IocMaking ing,
							Collection<?> col,
							Class<? extends Collection<Object>> type) {
		this.type = (Class<? extends Collection<Object>>) (null == type ? ArrayList.class : type);
		values = new ValueProxy[col.size()];
		int i = 0;
		for (Object obj : col)
			values[i++] = ing.makeValue(Loaders.object2value(obj));
	}

	public Object get(IocMaking ing) {
		try {
			Collection<Object> re = type.newInstance();
			for (ValueProxy vp : values)
				re.add(vp.get(ing));
			return re;
		} catch (Exception e) {
			throw Lang.wrapThrow(e);
		}
	}

}